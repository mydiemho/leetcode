package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by myho on 7/9/15.
 */

/*
* https://leetcode.com/discuss/21655/a-recursive-yet-efficient-java-solution-with-explanation
*  TOO MUCH COPYING IN THIS SOLUTION, but easier to understand
 */

/*
 * https://leetcode.com/problems/combination-sum/
 *
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 */
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // sort candidates to try them in asc order

        List<List<Integer>> allSolutions = new ArrayList<>();

        // store combinations we have seen so far
        ArrayList<Integer> currentSolution = new ArrayList<>();
        solve(allSolutions, currentSolution, candidates, target, 0);

        return allSolutions;
    }

    /*
     * start: the starting point in candidates from which we can take numbers from forwards
     *
     */
    private static void solve(List<List<Integer>> allSolutions, ArrayList<Integer> currentSolution, int[] candidates, int target, int startIndex) {
        // found solution, done
        if (target == 0) {
            allSolutions.add(new ArrayList<>(currentSolution));
            return;
        }

        // THIS CASE IS HANDLED IN THE FOR LOOP: target >= candidates[i]
        // no solution possible
        // it is impossible to find the combination onwards, because the “candidates” list is sorted and all the following elements would be greater than the “target” as well.
//        if (target < 0) {
//            return;
//        }

        // more moves remaining
        for (int i = startIndex; i < candidates.length && target >= candidates[i]; i++) {
            int newTarget = target - candidates[i];
            currentSolution.add(candidates[i]);

            // Try a new combination, one could repeat itself again, so start from "i", instead of "i+1"
            solve(allSolutions, currentSolution, candidates, newTarget, i);

            // backtracking
            // now try a solution without using this candidate
            currentSolution.remove(currentSolution.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        combinationSum(candidates, 7);
    }
}
