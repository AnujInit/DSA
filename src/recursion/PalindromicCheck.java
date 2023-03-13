package recursion;

public class PalindromicCheck {

    /**
     * TC= O(n)
     * Aux Space= O(n)
     */
    static boolean isPalindromic(String str, int start, int end){
        if(start >= end) return true;
        return  Character.compare(str.charAt(start), str.charAt(end)) == 0
                && isPalindromic(str, start+1, end-1);
    }
    public static void main(String[] args) {
        System.out.println(isPalindromic("abbcbba", 0, "abbcbba".length()-1));
        System.out.println(isPalindromic("abba", 0, "abba".length()-1));
        System.out.println(isPalindromic("geeks", 0, "geeks".length()-1));
    }
}
