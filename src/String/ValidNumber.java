package String;

/**
 * Created by myho on 7/22/15.
 */
public class ValidNumber {
    public static boolean isNumber(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < 0 || s.charAt(i) > 9) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumber("0.1"));

    }
}
