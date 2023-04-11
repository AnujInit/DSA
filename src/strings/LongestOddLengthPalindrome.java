package strings;

public class LongestOddLengthPalindrome {

    /**
     * Total  number of substring: O(n^2)
     * isPalaindromic string: O(n)
     * SO Tc = ( n^3)
     * @param str
     * @return
     */
    static int longestOddLengthPalindrome_Bruteforce(String str){
        int res = 1; //single character always be palindromic
        for (int i = 3; i <= str.length(); i = i+2) {
            for (int j = 0; j < str.length() - i + 1 ; j++) {
                if(isPalindrome(str, j, j+i-1)){
                    res = i;
                    break;
                }
            }
        }
        return res;
    }

    /**
     * for every i as middle, find the longest odd length palindromic.
     * TC: O(n^2)
     * @param str
     * @return
     */
    static int approach2(String str){
        int res = 1;
        for (int i = 1; i < str.length()-1 ; i++) {
            int left = i-1;
            int right = i+1;
            int len = 1;
            while (left >= 0 && right <= str.length()-1 && str.charAt(left) == str.charAt(right)){
                left--;
                right++;
                len += 2; // move two characters one in left and one in right
            }
            res = Math.max(res, len);
        }
        return res;
    }

    static boolean isPalindrome(String str, int left, int right){
        while (left < right){
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestOddLengthPalindrome_Bruteforce("abacbc"));
        System.out.println(longestOddLengthPalindrome_Bruteforce("choco"));
        System.out.println(longestOddLengthPalindrome_Bruteforce("racecap"));
        System.out.println();
        System.out.println(approach2("abacbc"));
        System.out.println(approach2("choco"));
        System.out.println(approach2("racecap"));

    }
}
