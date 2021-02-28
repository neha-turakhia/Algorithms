package Chapter1_ArrayString;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class PalindromePermutation {

    /**
     * CTCI 1.4 Check Permutation : Given a string, write a function to check if it is a permutation of a palindrome.
     *                              A palindrome is a word or phrase that is the same forwards and backwards.
     *                              A permutation is a rearrangement of letters.
     *                              The palindrome does not need to be limited to just dictionary words.
     *
     * EXAMPLE Input: Tact Coa
     * Output: True (permutations: "taco cat", "atco eta", etc.)
     *
     * Solution : Count the occurrences of each character. For a even length string every char in the palindrome occurs
     *            twice. But for an odd length string , every char but 1 has even occurrence but one char has an odd occurrence.
     *
     * Time Complexity : O(N+size of hashmap) ~ O(N)
     * Space Complexity : O(N) if all the characters are unique then the max size of the hashmap will be the size of the string
     **/


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

