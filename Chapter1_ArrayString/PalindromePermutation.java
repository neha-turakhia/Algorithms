package Chapter1_ArrayString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class PalindromePermutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean isPalindromePerm = checkForPalindromePerm(input);
        System.out.println(isPalindromePerm);
    }

    private static boolean checkForPalindromePerm(String s){
        s = s.toLowerCase();
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();++i) {
            char c = s.charAt(i);
            if(c != ' ') {
                hm.put(c, hm.getOrDefault(c, 0) + 1);
            }
        }

        boolean isOdd = false;
        Iterator i = hm.keySet().iterator();
        while(i.hasNext()){
            char c = (char) i.next();
            if(hm.get(c) % 2 !=0) {
                if(isOdd) {
                    return false;
                }
                isOdd=true;
            }
        }
        return true;
    }
}

