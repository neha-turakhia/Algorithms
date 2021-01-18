package Chapter1_ArrayString;

import java.util.Scanner;

public class IsUnique {
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
        /**
         * Assumption - that the input will only be 7 bit ASCII (128 chars)
         * Reason - if the unique string is exponentially long then the hashmap/hashset would be a very expensive choice for storage.
         * For a HashSet/HashMap the Space Complexity ~ O(n)  hashset/hashmap
         * In case of a char array, Space Complexity ~ O(1) since it is either 128 or 256 depending on whether it is 128/256 ASCII
         **/
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