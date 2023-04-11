package strings;

import java.util.TreeMap;

/**
 * Given a string of lower case characters, sort it in dictionary order.
 */
public class DictionaryOrderSorting {

    /**
     * Require frequency array of 26 characters
     * because we have string only with lower case characters
     * @param str
     * @return
     */
    static String approach1(String str){
        int n =  str.length();
        char[] chars =  str.toCharArray();
        int[] frequency = new int[26];

        //fill the frequency arr
        for (int i = 0; i < n; i++)
            frequency[chars[i] - 'a'] += 1;

        int curIndex = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < frequency[i]; j++) {
                chars[curIndex] = (char) (i+'a');
                curIndex++;
            }
        }
        return new String(chars);
    }

    /**
     * Instead of using array we can use sorted map means TreeMap
     * @param str
     * @return
     */
    static String approach2(String str){
        int n =  str.length();
        char[] chars =  str.toCharArray();
        TreeMap<Character, Integer> frequencyMap = new TreeMap<>();

        //fill the frequency map
        for (int i = 0; i < n; i++)
            frequencyMap.put(chars[i], frequencyMap.getOrDefault(chars[i], 0) +1);

        int index =0;
        for (Character key : frequencyMap.keySet()) {
            int freq = frequencyMap.get(key);
            while(freq-- > 0){
               chars[index] = key;
               index++;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(approach1("dabedbddba"));
        System.out.println(approach1("dabedx"));
        System.out.println(approach1("cabbd"));

        System.out.println();

        System.out.println(approach2("dabedbddba"));
        System.out.println(approach2("dabedx"));
        System.out.println(approach2("cabbd"));
    }
}
