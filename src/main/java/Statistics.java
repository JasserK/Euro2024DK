import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {

    private List<MatchResult> matchResults;

    public Statistics(String fileName) throws FileNotFoundException {
        MatchResultFileReader reader = new MatchResultFileReader("Euro2024QualifyingRound.csv");
        this.matchResults = reader.readFile();
    }

    public Set<String> getGoalScorers() {
        Set<String> goalScorers = new HashSet<>();
        for (MatchResult matchResult : matchResults) {
            goalScorers.addAll(matchResult.getGoalScorers());
        }
        return goalScorers;
    }

    public Map<String, Integer> getGoalScorersWithTotals() {
        Map<String, Integer> goalScorersTotals = new HashMap<>();
        for (MatchResult matchResult : matchResults) {
            for (String goalScorer : matchResult.getGoalScorers()) {
                goalScorersTotals.put(goalScorer, goalScorersTotals.getOrDefault(goalScorer, 0) + 1);
            }
        }
        return goalScorersTotals;
    }

    public int getNumberOfGoals(String goalScorer) {
        int totalGoals = 0;
        for (MatchResult matchResult : matchResults) {
            totalGoals += Collections.frequency(matchResult.getGoalScorers(), goalScorer);
        }
        return totalGoals;
    }
}
