package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventUtils {

    public static String getInputAsString(int day, boolean test){
        Scanner file = getInputFile(day, test);
        return file.nextLine();
    }

    public static List<String> getInputAsList(int day, boolean test){
        List<String> lines = new ArrayList<>();
        Scanner file = getInputFile(day, test);
        while(file.hasNextLine()){
            lines.add(file.nextLine());
        }
        return lines;
    }

    private static Scanner getInputFile(int day, boolean test){
        String path = String.format("inputs/day%d/Day%d.%s", day, day, test ? "test" : "in");
        try{
            return new Scanner(new File(path));
        }catch(FileNotFoundException e){
            e.printStackTrace();
            return null;
        }
    }
}
