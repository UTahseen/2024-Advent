import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day03_Part1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day3Input.txt");
        String input = "";
        for (int i = 0; i < fileData.size(); i++){
            input += fileData.get(i);
        }
        ArrayList<String> allMatches = new ArrayList<String>();
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