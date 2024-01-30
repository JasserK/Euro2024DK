import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            String fileName = "Euro2024QualifyingRound.csv";

            MatchResultFileReader fileReader = new MatchResultFileReader(fileName);
            List<MatchResult> matchResults = fileReader.readFile();

            System.out.println("Match Results:");
            for (MatchResult result : matchResults) {
                System.out.println(result.getGoalScorers());
            }

            Statistics statistics = new Statistics(fileName);

            System.out.println("\nAll Goal Scorers:");
            Set<String> allGoalScorers = statistics.getGoalScorers();
            System.out.println(allGoalScorers);

            System.out.println("\nGoal Scorers with Totals:");
            Map<String, Integer> goalScorersTotals = statistics.getGoalScorersWithTotals();
            goalScorersTotals.forEach((goalScorer, goals) ->
                    System.out.println(goalScorer + ": " + goals + " goals"));

            String specificGoalScorer = "Højlund";
            int numberOfGoals = statistics.getNumberOfGoals(specificGoalScorer);
            System.out.println("\nNumber of goals for " + specificGoalScorer + ": " + numberOfGoals);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
