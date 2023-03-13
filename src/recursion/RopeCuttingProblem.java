package recursion;

/**
 * Given a rope of length n, you need to find the maximum number of pieces
 * you can make such that the length of every piece is in set {a, b, c} for
 * the given three values a, b, c
 *
 * https://stackoverflow.com/questions/63250075/find-the-maximum-number-of-pieces-a-rod-can-be-cut
 */
public class RopeCuttingProblem {
    static int maxCuts(int n, int a, int b, int c){
        //Base Conditions
        if(n < 0) return -1;
        if(n == 0) return 0;

        int res =  max(maxCuts(n-a,a,b,c), maxCuts(n-b,a,b,c), maxCuts(n-c,a,b,c));

        //Boundary Conditions
        if(res == -1) return -1;

        return (1 + res);
    }

    static int max(int... num){
        int max = num[0];
        for (int i = 1; i < num.length; i++) {
            max = Math.max(max, num[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(maxCuts(5, 2,5,1));
        System.out.println(maxCuts(23, 12,9,11));
        System.out.println(maxCuts(5, 4,2,6));
    }
}
