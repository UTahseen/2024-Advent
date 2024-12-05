import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02_Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        int safe = 0;
        for (int i = 0; i < fileData.size(); i++){
            String[] levels = fileData.get(i).split(" ");
            int last = Integer.parseInt(levels[0]);
            int direction;
            int lastDir = 0;
            boolean currentSafe = false;
            boolean tolerated = false;
            ArrayList<Integer> levelsArr = new ArrayList<>();
            for (int j = 0; j < levels.length; j++){
                levelsArr.add(Integer.parseInt(levels[j]));
            }
            for (int j = 1; j < levelsArr.size(); j++){
                currentSafe = false;
                int current = levelsArr.get(j);
                direction = current - last;
                if (direction <= 3 && direction >= -3 && direction != 0 && !(direction > 0 && lastDir < 0) && !(direction < 0 && lastDir > 0)){
                    currentSafe = true;
                    last = current;
                    lastDir = direction;
                }
                else if (!tolerated){
                    if (j == levels.length - 1){
                        currentSafe = true;
                        tolerated = true;
                    }
                    else if (j == 1){
                        j++;
                        current = Integer.parseInt(levels[j]);
                        direction = current - last;
                        if (direction <= 3 && direction >= -3 && direction != 0){
                            currentSafe = true;
                            last = current;
                            lastDir = direction;
                            tolerated = true;
                        }
                        else break;
                    }
                    else {
                        j++;
                        current = Integer.parseInt(levels[j]);
                        direction = current - last;
                        if (direction <= 3 && direction >= -3 && direction != 0 && !(direction > 0 && lastDir < 0) && !(direction < 0 && lastDir > 0)){
                            currentSafe = true;
                            last = current;
                            lastDir = direction;
                            tolerated = true;
                        }
                        else break;
                    }
                }
                else break;
            }
            if (currentSafe) safe++;
        }
        System.out.println(safe);
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