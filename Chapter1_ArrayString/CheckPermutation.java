package Chapter1_ArrayString;

import java.util.Scanner;

public class CheckPermutation {
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

        /**
         * Assumption - that the input will only be 7 bit ASCII (128 chars)
         * Reason - if the strings (assuming are of equal length) are exponentially long then the hashmap would be a very expensive choice for storage.
         * For a HashMap the Space Complexity ~ O(n)
         * In case of a char array, Space Complexity ~ O(1) since it is either 128 or 256 depending on whether it is 128/256 ASCII
         **/
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