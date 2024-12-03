import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01_Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++){
            String[] sides = fileData.get(i).split("   ");
            left.add(Integer.parseInt(sides[0]));
            right.add(Integer.parseInt(sides[1]));
        }
        int score = 0;
        for (int i = 0; i < left.size(); i++){
            int count = 0;
            for (int j = 0; j < right.size(); j++){
                if (left.get(i).equals(right.get(j))) count++;
            }
            score += (left.get(i) * count);
        }
        System.out.println(score);
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