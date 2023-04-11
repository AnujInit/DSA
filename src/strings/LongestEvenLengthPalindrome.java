package strings;

public class LongestEvenLengthPalindrome {

    /**
     * TC: O(n^2)
     * @param str
     * @return
     */
    static int longestEvenLengthPalindrome(String str){
        int res = 0;
        for (int i = 1; i < str.length()-1; i++) {
            int left = i-1;
            int right =i;
            int len = 0;
            while (left >= 0 && right <= str.length()-1 && str.charAt(left) == str.charAt(right)){
                left--;
                right++;
                len += 2;
            }
            res = Math.max(res,len);
        }
        return res;
    }
    public static void main(String[] args) {
        System.out.println(longestEvenLengthPalindrome("abba"));
        System.out.println(longestEvenLengthPalindrome("aabbae"));
        System.out.println(longestEvenLengthPalindrome("abc"));
    }
}
