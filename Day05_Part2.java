import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day05_Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String> pages = new ArrayList<>();
        for (String str : fileData){
            if (str.contains("|")) rules.add(str);
            else pages.add (str);
        }
        int sum = 0;
        for (String str : pages){
            boolean good = true;
            for (int i = 0; i < rules.size(); i++){
                String[] values = rules.get(i).split("\\|");
                if (str.contains(values[1]) && str.indexOf(values[0]) > str.indexOf(values[1])) good = false;
            }
            if (!good){
                String[] updates = order(rules, str);
                sum += Integer.parseInt(updates[updates.length / 2]);
            }
        }
        System.out.println(sum);
    }

    public static String[] order(ArrayList<String> rules, String update){
        String[] updates = update.split(",");
        int[] appearances = new int[updates.length];
        for (int i = 0; i < updates.length; i++){
            for (String rule : rules){
                String[] rulesArr = rule.split("\\|");
                int firstNum = Integer.parseInt(rulesArr[0]);
                int secondNum = Integer.parseInt(rulesArr[1]);
                if (update.contains(Integer.toString(firstNum)) && update.contains(Integer.toString(secondNum))){
                    if (firstNum == Integer.parseInt(updates[i])) appearances[i]++;
                }
            }
        }
        for (int i = 0; i < appearances.length; i++){
            int max = appearances[i];
            int index = i;
            for (int j = i+1; j < appearances.length; j++){
                if (appearances[j] > max){
                    max = appearances[j];
                    index = j;
                }
            }
            int temp = appearances[i];
            String tempStr = updates[i];
            appearances[i] = appearances[index];
            updates[i] = updates[index];
            appearances[index] = temp;
            updates[index] = tempStr;
        }
        return updates;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}