import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day03_Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        ArrayList<String> allMatches = new ArrayList<String>();
        String input = "";
        for (int i = 0; i < fileData.size(); i++) {
            input += fileData.get(i);
        }
        while (input.indexOf("don't()") >= 0){
            if (input.indexOf("do()") >= 0){
                if (input.indexOf("do()") > input.indexOf("don't()")) {
                    input = input.substring(0, input.indexOf("don't()")) + input.substring(input.indexOf("do()") + 4);
                }
                else input = input.substring(0, input.indexOf("do()")) + input.substring(input.indexOf("do()") + 4);
            }
            else input = input.substring(0, input.indexOf("don't()"));
        }
        String regex = "mul\\([1-9],[1-9]\\)";
        Matcher m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        regex = "mul\\([1-9],[1-9][0-9]\\)";
        m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        regex = "mul\\([1-9],[1-9][0-9][0-9]\\)";
        m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        regex = "mul\\([1-9][0-9],[1-9]\\)";
        m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        regex = "mul\\([1-9][0-9],[1-9][0-9]\\)";
        m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        regex = "mul\\([1-9][0-9],[1-9][0-9][0-9]\\)";
        m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        regex = "mul\\([1-9][0-9][0-9],[1-9]\\)";
        m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        regex = "mul\\([1-9][0-9][0-9],[1-9][0-9]\\)";
        m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        regex = "mul\\([1-9][0-9][0-9],[1-9][0-9][0-9]\\)";
        m = Pattern.compile(regex).matcher(input);
        while (m.find()) {
            allMatches.add(m.group());
        }
        int sum = 0;
        for (int i = 0; i < allMatches.size(); i++){
            String numsStr = allMatches.get(i).substring(4, allMatches.get(i).length() - 1);
            String[] nums = numsStr.split(",");
            sum += Integer.parseInt(nums[0]) * Integer.parseInt(nums[1]);
        }
        System.out.println(sum);
        //128,670,117 is too high
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