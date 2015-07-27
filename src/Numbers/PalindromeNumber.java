package Numbers;

/**
 * Created by myho on 7/3/15.
 */

/*
 * Problems related with numbers are frequently solved by / and %. No need of extra space is required.
 *
 *  https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    // sol 1: reverse int and compare
    public boolean isPalindrome(int x) {
        int tmp = x;
        int revX = 0;

        while (tmp > 0) {
            // 32 => revX = 0*10 + 32%10 = 0 + 2 = 2; tmp => 32/10 = 3
            // 2 => revX = 2*10 + 3%10 = 20 + 3 = 23; tmp => 3/10 = 0
            revX = revX * 10 + tmp % 10;
            tmp = tmp / 10;
        }

        if(revX == x) {
            return true;
        }

        return false;
    }
}
