import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day05_Part1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day5Input.txt");
        ArrayList<String> rules = new ArrayList<>();
        ArrayList<String> pages = new ArrayList<>();
        for (String str : fileData){
            if (str.indexOf("|") >= 0) rules.add(str);
            else pages.add (str);
        }
        int sum = 0;
        for (String str : pages){
            boolean good = true;
            for (int i = 0; i < rules.size(); i++){
                String[] values = rules.get(i).split("\\|");
                if (str.indexOf(values[1]) >= 0 && str.indexOf(values[0]) > str.indexOf(values[1])){
                    good = false;
                    break;
                }
            }
            if (good){
                String[] updates = str.split (",");
                sum += Integer.parseInt(updates[updates.length / 2]);
            }
        }
        System.out.println(sum);
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