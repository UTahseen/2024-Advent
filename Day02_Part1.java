import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day02_Part1 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/Day2Input.txt");
        int safe = 0;
        for (int i = 0; i < fileData.size(); i++){
            String[] levels = fileData.get(i).split(" ");
            int last = Integer.parseInt(levels[0]);
            int direction = 0;
            boolean currentSafe = false;
            for (int j = 1; j < levels.length; j++){
                currentSafe = false;
                int current = Integer.parseInt(levels[j]);
                if (Math.abs(current - last) > 3) break;
                else{
                    if (current - last > 0 && direction < 0) break;
                    else if (current - last < 0 && direction > 0) break;
                    else if (current - last == 0) break;
                    else{
                        direction = current - last;
                        currentSafe = true;
                        last = current;
                    }
                }
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