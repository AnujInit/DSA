package recursion;

import java.util.Arrays;

/**
 * Given a rope of length n, you need to find the maximum number of pieces
 * you can make such that the length of every piece is in set {a, b, c} for
 * the given three values a, b, c
 *
 * https://stackoverflow.com/questions/63250075/find-the-maximum-number-of-pieces-a-rod-can-be-cut
 */
public class RopeCuttingProblem {

    //To optimize the recursive call, we can create 1D array
    static Integer[] memo;

    /**
     *
     */
    static int maxCutsUsingRecursion(int n, int a, int b, int c){
        //Base Conditions
        if(n < 0) return -1;
        if(n == 0) return 0;

        int res =  max(maxCutsUsingRecursion(n-a,a,b,c), maxCutsUsingRecursion(n-b,a,b,c), maxCutsUsingRecursion(n-c,a,b,c));

        //Boundary Conditions
        if(res == -1) return -1;

        return (1 + res);
    }

    /**
     *      
     */
    static int maxCutsUsingDP(int n, int a, int b, int c){

        if(memo == null) {
            memo = new Integer[n+1];
        }
        //Base Conditions
        if(n < 0) return -1;
        if(n == 0) return 0;

        if(memo[n] != null) return memo[n];

        int res =  max(maxCutsUsingDP(n-a,a,b,c), maxCutsUsingDP(n-b,a,b,c), maxCutsUsingDP(n-c,a,b,c));

        //Boundary Conditions
        memo[n] = (res == -1) ?  -1 : (res+1);

        return memo[n];
    }

    static int max(int... num){
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            max = Math.max(max, num[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        //Using Recursion
        System.out.println(maxCutsUsingRecursion(5, 2,5,1));
        System.out.println(maxCutsUsingRecursion(23, 12,9,11));
        System.out.println(maxCutsUsingRecursion(5, 4,2,6));
        System.out.println(maxCutsUsingRecursion(9, 2,2,2));

        //Using Dynamic Programming
        System.out.println();
        memo =null;
        System.out.println(maxCutsUsingDP(5, 2,5,1));
        memo =null;
        System.out.println(maxCutsUsingDP(23, 12,9,11));
        memo =null;
        System.out.println(maxCutsUsingDP(5, 4,2,6));
        memo =null;
        System.out.println(maxCutsUsingDP(9, 2,2,2));
    }
}
