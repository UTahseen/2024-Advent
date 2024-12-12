import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day04_Part1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day4Input.txt");
        char[][] wordSearch = new char[fileData.get(0).length()][fileData.size()];
        for (int r = 0; r < fileData.size(); r++){
            for (int c = 0; c < fileData.get(r).length(); c++){
                wordSearch[r][c] = fileData.get(r).charAt(c);
            }
        }
        int appearances = 0;
        for (int r = 0; r < wordSearch.length; r++){
            for (int c = 0; c < wordSearch[r].length; c++){
                if (wordSearch[r][c] == 'x'){
                    if (c < wordSearch[r].length - 3){
                        if (wordSearch[r][c+1] == 'm' && wordSearch[r][c+2] == 'a' && wordSearch[r][c+3] == 's') appearances++;
                    }
                }
            }
        }
        System.out.println(appearances);
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