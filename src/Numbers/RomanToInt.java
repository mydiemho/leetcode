package Numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by myho on 7/4/15.
 */

/*
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInt {
    private static final Map<Character, Integer> keys;

    static {
        keys = new HashMap<>();
        keys.put('I', 1);
        keys.put('V', 5);
        keys.put('X', 10);
        keys.put('L', 50);
        keys.put('C', 100);
        keys.put('D', 500);
        keys.put('M', 1000);
    }

    public int romanToInt(String s) {

        //eg：Ⅲ=3,Ⅳ=4,Ⅵ=6,ⅩⅨ=19,ⅩⅩ=20,ⅩLⅤ=45,MCMⅩⅩC=1980
        // rules:
        // If the value to the right is less than value to the left, add
        // else subtract

        int index = s.length() - 1;
        int result = keys.get(s.charAt(index));
        int right = result;

        for (int i = index - 1; i >= 0; i--) {
            int current = keys.get(s.charAt(i));
            if(current >= right) {
                result += current;
            } else {
                result -= current;
            }

            right = current;
        }

        return result;
    }
}
