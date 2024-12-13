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
                if (wordSearch[r][c] == 'X'){
                    if (c < wordSearch[r].length-3 && wordSearch[r][c+1] == 'M' && wordSearch[r][c+2] == 'A' && wordSearch[r][c+3] == 'S') appearances++;
                    if (r < wordSearch.length-3 && wordSearch[r+1][c] == 'M' && wordSearch[r+2][c] == 'A' && wordSearch[r+3][c] == 'S') appearances++;
                    if (c > 2 && wordSearch[r][c-1] == 'M' && wordSearch[r][c-2] == 'A' && wordSearch[r][c-3] == 'S') appearances++;
                    if (r > 2 && wordSearch[r-1][c] == 'M' && wordSearch[r-2][c] == 'A' && wordSearch[r-3][c] == 'S') appearances++;
                    if (c < wordSearch[r].length-3 && r < wordSearch.length-3 && wordSearch[r+1][c+1] == 'M' && wordSearch[r+2][c+2]== 'A' && wordSearch[r+3][c+3] == 'S') appearances++;
                    if (c < wordSearch[r].length-3 && r > 2 && wordSearch[r-1][c+1] == 'M' && wordSearch[r-2][c+2]== 'A' && wordSearch[r-3][c+3] == 'S') appearances++;
                    if (c > 2 && r < wordSearch.length-3 && wordSearch[r+1][c-1] == 'M' && wordSearch[r+2][c-2]== 'A' && wordSearch[r+3][c-3] == 'S') appearances++;
                    if (c > 2 && r > 2 && wordSearch[r-1][c-1] == 'M' && wordSearch[r-2][c-2]== 'A' && wordSearch[r-3][c-3] == 'S') appearances++;
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