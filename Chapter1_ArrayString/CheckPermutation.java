package Chapter1_ArrayString;

import java.util.Scanner;

public class CheckPermutation {
    /**
     * CTCI 1.2 Check Permutation : Given two strings, write a method to decide if one is a permutation of the other.
     *
     * Solution1 : Using Hashmaps
     * Approach : Store string1 in the hashmap with a char count as the value and
     *            decrement the value for each char in the map while traversing string2.
     *
     * Disadvantage : if the 2 string are equal and exponentially long then it is a very costly operation.
     *
     * Time Complexity : O(N1+N2+1) ~ O(N1+N2) - if the two strings are of different length, O(N) - strings are of same length.
     * Note : HashMap lookup is of constant time lookup , hence we have added 1.
     *
     * Space Complexity: O(N1) ~ O(N) for the hashmap (to store string1)
     *
     *
     *
     * Solution 2: Using character arrays
     * Approach : We have assumed that the input will only be 7 bit ASCII (128 chars). We create a char array of length 128 and
     *            increment the count upon traversing string1. Then we traverse string2 and decrement the count for each of the chars
     *            in the array. If at any point the value in the char array is -1, this means that the strings are not a permutation
     *            of one another.
     *
     * Time Complexity : O(N1+N2) (if the strings are of unequal length) , O(N) (for equal length strings)
     * Space Complexity : O(1) since it is either 128 or 256 depending on whether it is 128/256 ASCII
     **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        boolean isPermutation = checkPermutation(s1,s2);
        System.out.println(isPermutation);
    }

    private static boolean checkPermutation(String s1,String s2){
        if(s1 == null && s2 == null) return true;
        if(s1 == null || s2 == null) return false;
        if(s1.length() != s2.length()) return false;

        /*Solution 1: Using HashMaps*/
        /*HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i< s1.length();++i){
            char c = s1.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        for(int i=0;i< s2.length();++i){
            char c = s2.charAt(i);
            if(!hm.containsKey(c) || (hm.containsKey(c) && hm.get(c) == 0)) {
               isPermutation = false;
               break;
            }
            hm.put(c,hm.getOrDefault(c,0)-1);
        }*/

        /*Solution 2: Using character arrays*/

        int[] ascii = new int[128];
        for(int i=0;i< s1.length();++i) {
            char c = s1.charAt(i);
            ascii[c]++;
        }

        for(int i=0;i< s2.length();++i){
            char c = s2.charAt(i);
            ascii[c]--;
            if(ascii[c] == -1){
               return false;
            }
        }
        return true;
    }
}