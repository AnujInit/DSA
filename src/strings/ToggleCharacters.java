package strings;

/**
 * Given a String, toggle the case of every character.
 */
public class ToggleCharacters {

    /**
     * Using ASCII Value concept
     * a - A = 32
     * @param str
     * @return
     */
    static String approach1(String str){
        int n = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < n; i++) {
            //Check for uppercase
            if(chars[i] >= 'A' && chars[i] <= 'Z'){
                chars[i] = (char) (chars[i] +32);
            }
            else {
                chars[i] = (char) (chars[i] - 32);
            }
        }
        return new String(chars);
    }

    /**
     * Using Bitwise concept
     * Toggle ith bit of a number = A^(1<<i)
     * In case of alphabats we have 32 difference So we need to toggle only 5bit.
     * @param str
     * @return
     */
    static String approach2(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        for (int i = 0; i < n; i++)
            chars[i] = (char)(chars[i]^(1<<5));
        return new String(chars);
    }
    public static void main(String[] args) {
        System.out.println(approach1("aBcdE"));
        System.out.println(approach2("aBcdE"));
    }
}
