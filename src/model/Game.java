package model;

import util.UtilFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Lucas on 16/06/2017.
 */
public class Game {
    public static final String TYPE_CORRECT = "C";
    public static final String TYPE_INCORRECT = "I";
    public static final String TYPE_CLARIFICATION_REQUEST = "R";
    public static final String TYPE_UNJUDGED = "U";
    public static final String TYPE_ERRONEOUS_SUBMISSION = "E";

    private File fileInput;
    private static FileOutputStream fileOutputStream;
    private Integer numberOfCases;
    private Collection<Case> cases = new ArrayList<>();

    public Game(String pathInputFile, String pathOutputFile) {
        try {
            fileOutputStream = new FileOutputStream(pathOutputFile, true);
            uploadFile(pathInputFile);
        } catch (FileNotFoundException e) {
            System.err.println("Problem in output file path");
        }
    }

    public File getFileInput() {
        return fileInput;
    }

    public void setFileInput(File fileInput) {
        this.fileInput = fileInput;
    }

    public Integer getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(Integer numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    public static FileOutputStream getFileOutputStream() {
        return fileOutputStream;
    }

    public static void setFileOutputStream(FileOutputStream fileOutputStream) {
        Game.fileOutputStream = fileOutputStream;
    }

    public Collection<Case> getCases() {
        return cases;
    }

    public void setCases(Collection<Case> cases) {
        this.cases = cases;
    }

    //Method that performs the file search in the path entered as a program parameter
    public void uploadFile(String path) {
        URL url = getClass().getResource(path);
        try {
            setFileInput(new File(url.toURI()));
        } catch (URISyntaxException e) {
            System.err.println("Problem in input file path");
        }
    }
}
