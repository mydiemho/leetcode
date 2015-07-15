package ArrayAndList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by myho on 7/6/15.
 */

/* https://leetcode.com/problems/two-sum/
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */
public class TwoSum {

    /* can't put every key in the map first, cause then
         we can't handle the case of duplicates

        [0, 4, 2, 0] => [1, 4]
     */
    public static int[] twoSum(int[] nums, int target) {

        // need to preserve insertion order
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];

            // see if we can find a complement
            int diff = target - val;

            if(map.containsKey(diff)) {
                // has previously seen the complement, so its index must be
                // before the current element
                return new int[]{map.get(diff), i+1};
            }

            map.put(val, i+1);
        }

        return new int[2];
    }

    public static void main(String[] args)
    {
        int[] array = new int[]{3, 2, 4};
        int sum = 6;
//        findPairMap(array, sum);
        twoSum(array, sum);
    }
}
