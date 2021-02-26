package Chapter1_ArrayString;

import java.util.Scanner;

public class IsUnique {
    /**
     * CTCI 1.1 IsUnique : Implement an algorithm to determine if a string has all unique characters.
     *                     What if you cannot use additional data structures?
     *
     *
     * Solution 1: Using HashMaps
     * Approach : Store every char and its count as a key-value pair in a hashmap.
     *            Traverse the string, if any char already exists return false.
     *
     *  Time Complexity - O(N)
     *  Space Complexity - O(N) - for the hashmap
     *
     *
     * Solution 2: Using HashSets
     * Approach : it is not necessary to persist the count of the character since we need to determine
     *            if every character exists only once. We can use hashsets for this , though this will not reduce
     *            the space complexity but it will reduce the space used by the algorithm by 1/2 since we dont store
     *            a key-value pair.
     * Note - hashset is used instead of a list since a lookup operation in hashset is of constant time ( O(1) )
     *        whereas it is O(N) for a list.
     *
     * Time Complexity :  O(N)
     * Space Complexity - O(N) - for the hashset
     *
     *
     * Solution 3: Using character arrays
     * Approach : It is assumed that the input will only be 7 bit ASCII (128 chars). We create a char array of length 128 and
     *            increment the count upon traversing the string. if any char has count greater than 1 already the string is not unique
     * Reason - if the unique string is exponentially long then the hashmap/hashset would be a very expensive choice for storage.
     *
     * Time Complexity : O(N)
     * Space Complexity ~ O(1) since it is either 128 or 256 depending on whether it is 128/256 ASCII
     *
     * **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        boolean isUnique = isUnique(s);
        System.out.println(isUnique);
    }

    private static  boolean isUnique(String s) {
        /*Solution 1 : Using HashMap*/
        /*HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(hm.containsKey(c)) {
                return false;
            }
            hm.put(c,hm.getOrDefault(c,0)+1);
        }*/

        /*Solution 2: Using HashSets*/
        /*HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(hs.contains(c)) {
                return false;
            }
            hs.add(c);
        }*/

        /*Solution 3: Using character arrays*/
        boolean[] ascii = new boolean[128];
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(ascii[c]){
                return false;
            }
            ascii[c]= true;
        }

        return true;
    }
}