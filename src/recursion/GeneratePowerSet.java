package recursion;

/**
 * Given a set represented as a string, write a recursive code to print all subsets of it.
 * The subsets can be printed in any order.
 *
 * Assumption: All the characters in given string are distinct.
 * NB:
 *  1) For a given string of length n, there are going to be 2^n subsets.
 *  2) This problem we can also treat as generating all subsequence of the string
 *  3) we can also solve this problem by iterative approach using bitwise operator concept
 *
 * https://www.geeksforgeeks.org/recursive-program-to-generate-power-set/
 */
public class GeneratePowerSet {

    static void subsetsUsingRecursive(String str, String current, int index){

        //Base Condition
        if(index == str.length()){
            System.out.print(current + " ");
            return;
        }

        //Not considering string index
        subsetsUsingRecursive(str, current, index+1);

        //Considering String index
        subsetsUsingRecursive(str, current + str.charAt(index), index+1);
    }

    static void subsetsUsingIterative(String str){
        //Get total possible subsets count
        long n = powerOf2(str.length());

        //consider nothing selected
        System.out.print(" ");

        //Start from 1 to n
        for (long i = 1; i < n; i++) {
            long bn = binaryNumber(i,1, 0);
            StringBuilder sb =  new StringBuilder();
            int index =0;
            while (bn != 0){
                long mod = bn % 10;
                if(mod != 0)
                    sb.append(str.charAt(index));
                bn = bn/10;
                index++;
            }
            System.out.print(sb.toString() + " ");
        }
    }

    /**
     * Decimal to Binary Conversion
     */
    static long binaryNumber(long num, long place, long result){
        if(num == 0) return result;
        return binaryNumber(num/2, place*10, result + ((num%2)*place));
     }

    /**
     * Power of 2
     */
     static long powerOf2(int pow) {
        long res = 1;
        while (pow != 0){
            res *= 2;
            pow--;
         }
        return res;
     }

    public static void main(String[] args) {
        subsetsUsingRecursive("abc", "", 0);
        System.out.println();
        subsetsUsingRecursive("abcd", "", 0);
        System.out.println();
        subsetsUsingIterative("abc");
        System.out.println();
        subsetsUsingIterative("abcd");
    }
}
