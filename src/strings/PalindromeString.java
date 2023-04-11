package strings;

public class PalindromeString {

    /**
     * Two Pointer Approach
     * @param str
     * @return
     */
    static boolean isPalindrome(String str){
        int left = 0, right = str.length() -1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome("naman"));
        System.out.println(isPalindrome("racecar"));
        System.out.println(isPalindrome("race"));
    }
}
