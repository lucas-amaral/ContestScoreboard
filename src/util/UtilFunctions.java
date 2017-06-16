package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Lucas on 16/06/2017.
 */
public class UtilFunctions {

    //Returns the next value of the current read line from the input file
    public static Integer searchNextValue(String line) {
        return Integer.valueOf(line.substring(0,2).trim());
    }

    public static Scanner readFile(File file, String delimiter) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file).useDelimiter(delimiter);
        } catch (FileNotFoundException e) {
            System.err.println("Problem in input file path");
        }
        return scanner;
    }
}
