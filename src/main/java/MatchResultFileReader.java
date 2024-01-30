import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatchResultFileReader {

    private String fileName;

    public MatchResultFileReader(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
    }

    public List<MatchResult> readFile() throws FileNotFoundException {
        List<MatchResult> matchResults = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    String teams = parts[0];
                    List<String> goalScorers = Arrays.asList(parts[1].split(","));
                    matchResults.add(new MatchResult(teams, goalScorers));
                } else {
                    System.out.println("Invalid file format in line: " + line);
                }
            }
        }
        return matchResults;
    }
}
