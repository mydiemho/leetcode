package String;

// Given a string S, find the longest palindromic substring in S.
// You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

//http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/

public class PalindromicSubstring
{
    // O(n^3)
    public static String longestPalindrome1(String input)
    {
        if(input == null || input.length() == 0){
            return input;
        }

        int maxLength = 0;
        // every character is a palindrome
        String result = input.substring(0, 1);
        for(int i = 0; i < input.length(); i++)
        {
            for(int j = i + 1; j < input.length(); j++){
                String currentString = input.substring(i, j+1);
                if(isPalindrome(currentString)) {
                    int currentLength = currentString.length();
                    if(currentLength > maxLength) {
                        maxLength = currentLength;
                        result = currentString;
                    }
                }
            }
        }

        return result;
    }

    // O(n^2), space O(1)
    public static String longestPalindrome2(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }

        String longest = input.substring(0, 1);

        for(int i = 0; i < input.length(); i++)
        {
            // find odd length palindrome substring with center (i, i)
            String substring = findPalindromeSub(i, i, input);

            if(substring.length() > longest.length())
            {
                longest = substring;
            }

            // find even length palindrome substring with center (i, i)
            substring = findPalindromeSub(i, i+1, input);
            if(substring.length() > longest.length())
            {
                longest = substring;
            }
        }

        return longest;
    }

    private static String findPalindromeSub(int beginIndex, int endIndex, String input)
    {
        while(beginIndex >= 0 && endIndex < input.length() &&  input.charAt(beginIndex) == input.charAt(endIndex))
        {
            beginIndex -= 1;
            endIndex += 1;
        }

        // begin + 1 b/c we move to left and right one over, but endIndex is exclusive
        String tmp = input.substring(beginIndex + 1, endIndex);
        return tmp;
    }

    private static boolean isPalindrome(String input)
    {
        int maxIndex = input.length() - 1;
        for(int i = 0; i < input.length(); i++)
        {
            if(input.charAt(i) != input.charAt(maxIndex - i))
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args)
    {
        String input = "banana";
//        System.out.println(longestPalindrome1(input));
//        System.out.println(longestPalindrome2(input));

        input = "abuttuba";
        System.out.println(longestPalindrome1(input));
        System.out.println(longestPalindrome2(input));
    }
}
