package recursion;

public class SumOfDigits {
    static long sum(long n, long k){
        if(n <= 9) return k+n;
        return sum(n/10, k + (n%10));
    }
    public static void main(String[] args) {
        System.out.println(sum(253,0));
        System.out.println(sum(9987,0));
        System.out.println(sum(10,0));
    }
}
