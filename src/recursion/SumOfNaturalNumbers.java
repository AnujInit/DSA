package recursion;

public class SumOfNaturalNumbers {

    static long sum(int n, int k){
        if(n == 0) return k;
        return sum(n-1, n+k);
    }

    public static void main(String[] args) {
        System.out.println(sum(5,0));
    }
}
