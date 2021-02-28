package Chapter1_ArrayString;

import java.util.Scanner;

public class OneAway {

    /**
     * CTCI 1.5 One Away: There are three types of edits that can be performed on strings:
     *                    insert a character remove a character, or replace a character.
     *                    Given two strings, write a function to check if they are one edit (or zero edits) away.
     *
     *  EXAMPLE :-
     *  pale, ple -> true
     *  pales, pale -> true
     *  pale, bale -> true
     *  pale, bake -> false
     *
     *  Solution : for same length strings check for one replace , and for strings with a difference of 1 char check for insert/delete
     *  Time Complexity : O(N)
     *  Space Complexity : O(1)
     **/


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        boolean isOneAway = oneAway(s1,s2);
        System.out.println(isOneAway);
    }

    private static boolean oneAway(String s,String t){
        int sLen = s.length();
        int tLen = t.length();
        int lenDiff = Math.abs(sLen-tLen);
        if(lenDiff >= 2) return false;

        boolean isOneEditAway = false;
        if(sLen == tLen) {
            isOneEditAway = checkReplace(s,t);
        }else {
            if(sLen <tLen) {
                isOneEditAway = checkInsertOrDelete(s,t);
            }else {
                isOneEditAway = checkInsertOrDelete(t,s);
            }

        }
        return isOneEditAway;
    }

    private static boolean checkReplace(String s, String t) {
        //Here length of both strings are equal
        boolean firstDiff = false;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i) != t.charAt(i)) {
                if(firstDiff) {
                    return false;
                }
                firstDiff = true;
            }
        }
        return true;
    }

    private static boolean checkInsertOrDelete(String s,String t){
        //It is always assumed that s will be the smaller string
        if(s.length() ==0) return true;

        int i=0,k=0;
        boolean firstDiff = false;
        while(i<t.length() || k<s.length()){
            if(k == s.length() && !firstDiff) return true; //Since the string s is smaller and the same as all chars of t then there will be only 1 char difference i.e of the remaining char of t
            if(s.charAt(k) != t.charAt(i)) {
                //k is NOT incremented if the chars are different to compare the char at index k with the next index of i
                //s= ac , t = abc -- to check if there is more than 1 char diff
                if(firstDiff) {
                    return false;
                }
                firstDiff = true;
            }else {
                k++;
            }
            i++;
        }
        return true;
    }
}
