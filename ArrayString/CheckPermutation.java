package ArrayString;

import java.util.HashMap;
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

        boolean isPermutation = true;
        HashMap<Character,Integer> hm = new HashMap<>();
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
        }

        return isPermutation;
    }
}