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
            int last = Integer.parseInt(levelsArr[0]);
            int direction;
            int lastDir = 0;
            boolean currentSafe = false;
            boolean tolerated = false;
            ArrayList<Integer> levels = new ArrayList<>();
            for (int j = 0; j < levelsArr.length; j++){
                levels.add(Integer.parseInt(levelsArr[j]));
            }
            for (int j = 1; j < levels.size(); j++){
                currentSafe = false;
                int current = levels.get(j);
                direction = current - last;
                if (direction <= 3 && direction >= -3 && direction != 0 && !(direction > 0 && lastDir < 0) && !(direction < 0 && lastDir > 0)){
                    currentSafe = true;
                    last = current;
                    lastDir = direction;
                }
                else if (!tolerated){
                    tolerated = true;
                    if (j == levels.size() - 1){
                        currentSafe = true;
                    }
                    else if (j == 1){
                        j++;
                        current = levels.get(j);
                        direction = current - last;
                        if (direction <= 3 && direction >= -3 && direction != 0){
                            currentSafe = true;
                            last = current;
                            lastDir = direction;
                        }
                        else{
                            last = levels.get(j-1);
                            direction = current - last;
                            if (direction <= 3 && direction >= -3 && direction != 0){
                                currentSafe = true;
                                last = current;
                                lastDir = direction;
                            }
                            else break;
                        }
                    }
                    else{
                        j++;
                        current = levels.get(j);
                        direction = current - last;
                        if (direction <= 3 && direction >= -3 && direction != 0){
                            currentSafe = true;
                            last = current;
                            lastDir = direction;
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