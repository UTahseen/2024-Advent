import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day06_Part1 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day6Input.txt");
        String[][] map = new String[fileData.size()][fileData.get(0).length()];
        boolean onMap = true;
        int row = 0;
        int col = 0;
        for (int r = 0; r < map.length; r++){
            for (int c = 0; c < map[r].length; c++){
                map[r][c] = fileData.get(r).substring(c, c+1);
                if (map[r][c].equals("^") || map[r][c].equals("v") || map[r][c].equals("<")|| map[r][c].equals(">")) {
                    row = r;
                    col = c;
                }
            }
        }
        while (onMap){
            if (map[row][col].equals("^")){
                while (!map[row-1][col].equals("#") && onMap){
                    map[row][col] = "X";
                    map[row][col+1] = "^";
                    col++;
                    if (col == map[row].length-1){
                        map[row][col] = "X";
                        onMap = false;
                    }
                }
                if (onMap) map[row][col] = "^";
            }
            else if (map[row][col].equals(">")){
                while (!map[row][col+1].equals("#") && onMap){
                    map[row][col] = "X";
                    map[row][col+1] = "^";
                    col++;
                    if (col == map[row].length-1){
                        map[row][col] = "X";
                        onMap = false;
                    }
                }
                if (onMap) map[row][col] = "^";
            }
            else if (map[row][col].equals("v")){
                while (!map[row+1][col].equals("#") && onMap){
                    map[row][col] = "X";
                    map[row+1][col] = "^";
                    row++;
                    if (row == map.length-1){
                        map[row][col] = "X";
                        onMap = false;
                    }
                }
                if (onMap) map[row][col] = "<";
            }
            else if (map[row][col].equals("<")){
                while (!map[row][col-1].equals("#") && onMap){
                    map[row][col] = "X";
                    map[row][col-1] = "<";
                    col--;
                    if (col == 0){
                        map[row][col] = "X";
                        onMap = false;
                    }
                }
                if (onMap) map[row][col] = "^";
            }
        }
        for (int r = 0; r < map.length; r++){
            for (int c = 0; c < map[r].length; c++){
                System.out.print(map[r][c]);
            }
            System.out.println();
        }
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