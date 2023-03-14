package recursion;

/**
 * Tower of Hanoi is a mathematical puzzle where we have three rods (A, B, and C) and N disks.
 * Initially, all the disks are stacked in decreasing value of diameter i.e., the smallest disk is placed on the top
 * and they are on rod A. The objective of the puzzle is to move the entire stack to another rod (here considered C),
 * obeying the following simple rules:
 *  1) Only one disk can be moved at a time.
 *  2) Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 *  3) No disk may be placed on top of a smaller disk.
 *
 * NB:
 *  1) Number of movements = (2^n) - 1
 *  2) GP series 1+2+4 + ---- + (2^n)
 *  3) T(n) = 2T(n-1) + 1
 *
 *  https://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/
 */
public class TowerOfHanoi {
    /**
     * TC= O(2^n) because There are two possibilities for every disk.
     *
     */
    static void toh(int n, String src, String aux, String dest){

        //Base condition
        if(n==1){
            System.out.println("Move 1 from " +  src + " to " + dest);
            return;
        }
        //Move (n-1) disk from src to aux tower using dest tower
        toh(n-1, src, dest, aux);

        //Move nth disk from src to dest tower
        System.out.println("Move " + n + " from " +  src + " to " + dest);

        //Move (n-1) disk from aux to dest tower using src tower
        toh(n-1, aux, src, dest);


    }

    public static void main(String[] args) {
        toh(3, "A", "B", "C");
    }
}
