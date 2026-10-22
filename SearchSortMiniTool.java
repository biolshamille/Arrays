import java.util.Arrays;

public class SearchSortMiniTool {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 90, 88, 76, 95, 84};
        int target = 90;
        int foundIndex = -1;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == target) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Score found: " + target);
            System.out.println("Index: " + foundIndex);
        } else {
            System.out.println("Score not found: " + target);
        }

        int[] sortedScores = Arrays.copyOf(scores, scores.length);
        Arrays.sort(sortedScores);

        System.out.println("Original Scores: " + Arrays.toString(scores));
        System.out.println("Sorted Scores: " + Arrays.toString(sortedScores));
    }
}
