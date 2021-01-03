package ArrayString;

import java.io.InvalidObjectException;
import java.util.Scanner;

public class URLify {
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