package Chapter1_ArrayString;

import java.io.InvalidObjectException;
import java.util.Scanner;

public class URLify {
    /**
     * CTCI 1.3 URLify : Write a method to replace all spaces in a string with '%20 You may
     *                 assume that the string has sufficient space at the end to hold the additional
     *                 characters, and that you are given the "true" length of the string. (Note: if
     *                 implementing in Java, please use a character array so that you can perform
     *                 this operation in place.)
     *  Example Input: "Mr John Smith     ", 13
     *  Output: "Mr%20John%20Smith"
     **/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] str = scanner.nextLine().toCharArray();
        int trueLength = scanner.nextInt();
        try {
            urlify(str, trueLength);
            System.out.println(str);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    private static void urlify(char[] s,int trueLen) throws Exception{
        int spaces = 0;
        for(int i=0;i<trueLen;++i){
            if(s[i] == ' ') {
                spaces++;
            }
        }
        /**
         * If we start at the end of the array then the output may not be right if there are extra spaces
         * So we need to calculate the extra space required to replace ' ' with '%20' and
         * start filling up the array from that position replacing the characters all along to the beginning
         **/
        int k=trueLen+(spaces*2)-1; //this is the essence of the problem
        if(k > s.length) throw new InvalidObjectException("Invalid Input passed");
        for(int i=trueLen-1;i>=0;){
            if(s[i] == ' ') {
                s[k]='0';
                s[k-1]='2';
                s[k-2]='%';
                k=k-3;
            }else{
               s[k--]=s[i];
            }
            i--;
        }
    }
}