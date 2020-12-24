package ArrayString;

import java.util.HashMap;
import java.util.HashSet;
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
        HashSet<Character> hs = new HashSet<>();
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(hs.contains(c)) {
                return false;
            }
            hs.add(c);
        }
        return true;
    }
}