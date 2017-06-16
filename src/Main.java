import model.Case;
import model.Contestant;
import model.Game;
import util.UtilFunctions;

import java.io.*;
import java.util.*;

public class Main {

    //Method responsible for reading the input file and performing the necessary operations
    private static void execute(Game game) {
        Case currentCase = null;
        Scanner scanner = UtilFunctions.readFile(game.getFileInput(), "\n");
        game.setNumberOfCases(Integer.valueOf(scanner.nextLine()));
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.trim().equals("")) {
                if (game.getCases().size() < game.getNumberOfCases()) {
                    currentCase = new Case(game.getCases().size());
                    game.getCases().add(currentCase);
                } else {
                    System.err.println("Current case exceeds number indicated in input file");
                }
            } else if (line.matches("[0-9]* [0-9]* [0-9]* (I|C|R|U|E)")) {
                Integer numberContestant = UtilFunctions.searchNextValue(line);
                line = line.replaceFirst("[0-9]*", "").trim();
                if (!currentCase.getContestants().containsKey(numberContestant)) {
                    Contestant contestant = new Contestant(numberContestant);
                    currentCase.getContestants().put(numberContestant, contestant);
                }
                Contestant currentContestant = currentCase.getContestants().get(numberContestant);
                if (line.contains(Game.TYPE_INCORRECT) || line.contains(Game.TYPE_CORRECT)) {
                    Integer problemNumber = UtilFunctions.searchNextValue(line);
                    line = line.replaceFirst("[0-9]*", "").trim();
                    Integer time = UtilFunctions.searchNextValue(line);
                    if (line.contains(Game.TYPE_INCORRECT)) {
                        time = 20;
                    }
                    currentContestant.getProblems().add(problemNumber);
                    currentContestant.setTime(currentContestant.getTime() + time);
                }
            }
        }
        writeOutput(game);
    }

    //Method that writes the output file output.txt
    private static void writeOutput(Game game) {
        System.setOut(new PrintStream(game.getFileOutputStream()));
        for (Case currentCase : game.getCases()){
            for (Contestant contestant : currentCase.getContestants().values()) {
                System.out.println(contestant.getNumber() + " " + contestant.getNumberOfProblems() + " " + contestant.getTime());
                System.out.println(" ");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Game game = new Game("../input.txt","output.txt");
        Main.execute(game);
    }
}
