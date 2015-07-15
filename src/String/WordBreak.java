package String;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by myho on 8/9/14.
 */
public class WordBreak {
    public static boolean wordBreak1(String s, Set<String> dict) {
        return wordBreakHelper(s, dict, 0);
    }

    private static boolean wordBreakHelper(String s, Set<String> dict, int startIndex) {

        // empty string
        if(startIndex == s.length())
        {
            return true;
        }

        for (String word : dict)
        {
            int wordLength = word.length();
            int endIndex = startIndex + wordLength;
            if(endIndex > s.length())
            {
                // sequence is shorter than current word in dictionary
                // cannot construct word starting at this index
                continue;
            }

            String subsequence = s.substring(startIndex, endIndex);
            if(word.equals(subsequence))
            {
                if(wordBreakHelper(s, dict, endIndex)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean[] f = new boolean[len+1];

        // empty string is always true
        f[0] = true;

        for(int i = 1; i <= len; i++) {
            for(int j = 0; j < i; j++) {

                // is there a way to segment the words
                // from j to i - 1 (inclusive)?
                if( f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[len];
    }

//    Input:	"a", ["a"]
//    Output:	false
//    Expected:	true


//    Input:	"aaaaaaa", ["aaaa","aa"]
//    Output:	true
//    Expected:	false
    public static void main(String[] args)
    {
//        String s1 = "leetcode";
//        Set<String> dict1 = new HashSet<>();
//        dict1.add("leet");
//        dict1.add("code");
//
//        System.out.println(wordBreak(s1, dict1));
//
//        String s2 = "a";
//        Set<String> dict2 = new HashSet<>();
//        System.out.println(wordBreak(s2, dict2));

//        String s3 = "a";
//        Set<String> dict3 = new HashSet<>();
//        dict3.add("a");
//        System.out.println(wordBreak(s3, dict3));

        String s4 = "aaaaaaa";
        Set<String> dict4 = new HashSet<>();
        dict4.add("aaaa");
        dict4.add("aa");
        System.out.println(wordBreak(s4, dict4));
    }
}
