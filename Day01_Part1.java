import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day01_Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day1Input.txt");
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        for (int i = 0; i < fileData.size(); i++){
            String[] sides = fileData.get(i).split("   ");
            left.add(Integer.parseInt(sides[0]));
            right.add(Integer.parseInt(sides[1]));
        }
        for (int i = 0; i < left.size(); i++){
            int leftSmallest = Integer.MAX_VALUE;
            int rightSmallest = Integer.MAX_VALUE;
            int leftIndex = i;
            int rightIndex = i;
            for (int j = i; j < left.size(); j++){
                if (left.get(j) < leftSmallest){
                    leftSmallest = left.get(j);
                    leftIndex = j;
                }
                if (right.get(j) < rightSmallest){
                    rightSmallest = right.get(j);
                    rightIndex = j;
                }
            }
            int holder = left.get(i);
            left.set(i, leftSmallest);
            left.set(leftIndex, holder);
            holder = right.get(i);
            right.set(i, rightSmallest);
            right.set(rightIndex, holder);
        }
        int difference = 0;
        for (int i = 0; i < left.size(); i++){
            difference += Math.abs(left.get(i) - right.get(i));
        }
        System.out.println(difference);
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