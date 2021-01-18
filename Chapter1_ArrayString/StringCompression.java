package Chapter1_ArrayString;

import java.util.Scanner;

public class StringCompression {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String compressed_string = compress(str);
        System.out.println(compressed_string);
    }

    private static String compress(String original){
        StringBuilder sb = new StringBuilder();
        char prev = original.charAt(0);
        int count = 1;
        for(int i=1;i<original.length();++i){
            if(original.charAt(i) == prev) {
                count++;
            }else{
                sb.append(prev);
                sb.append(count);
                count = 1;
            }
            prev = original.charAt(i);
        }

        sb.append(prev);
        sb.append(count);
        return sb.length() >= original.length() ? original : sb.toString();
    }
}