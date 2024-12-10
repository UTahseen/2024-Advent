import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02_Part2 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        int safe = 0;
        for (int i = 0; i < fileData.size(); i++){
            String[] levelsArr = fileData.get(i).split(" ");
            ArrayList<Integer> levels = new ArrayList<>();
            for (int j = 0; j < levelsArr.length; j++){
                levels.add(Integer.parseInt(levelsArr[j]));
            }
            if (checkLevel(levels)) safe++;
            else {
                for (int j = 0; j < levels.size(); j++){
                    ArrayList<Integer> toleration = new ArrayList<>();
                    for (int k = 0; k < levelsArr.length; k++){
                        toleration.add(Integer.parseInt(levelsArr[k]));
                    }
                    toleration.remove(j);
                    if (checkLevel(toleration)){
                        safe++;
                        break;
                    }
                }
            }
        }
        System.out.println(safe);
    }

    public static Boolean checkLevel(ArrayList<Integer> levels){
        int last = levels.get(0);
        int lastDir = 0;
        for (int j = 1; j < levels.size(); j++){
            int current = levels.get(j);
            int direction = current - last;
            if (direction <= 3 && direction >= -3 && direction != 0 && !(direction > 0 && lastDir < 0) && !(direction < 0 && lastDir > 0)){
                last = current;
                lastDir = direction;
            }
            else return false;
        }
        return true;
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