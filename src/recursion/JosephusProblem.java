package recursion;

import java.util.List;

/**
 * There are N people standing in a circle waiting to be executed. The counting out begins at some point in the circle
 * and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped
 * and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller
 * as the executed people are removed), until only the last person remains, who is given freedom.
 * Given the total number of persons N and a number k which indicates that k-1 persons are skipped
 * and the kth person is killed in a circle. The task is to choose the person in the initial circle that survives.
 *
 * https://www.geeksforgeeks.org/josephus-problem/
 */
public class JosephusProblem {
    static void josh(List<Integer> persons, int k, int index){

        //Base Condition: when only one person is left
        if(persons.size() == 1) {
            System.out.println("Freedom person: " + persons.get(index));
        }

        // find the index of first person which will die
        index = ((index+k) % persons.size());

        // remove the first person which is going to be killed
        persons.remove(index);

        // recursive call for n-1 persons
        josh(persons, k, index);
    }
    public static void main(String[] args) {

    }
}
