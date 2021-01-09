package ArrayString;

import java.util.Scanner;

public class StringRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        boolean isRotatedString = isRotatedString(s1,s2);
        System.out.println(isRotatedString);
    }

    private static boolean isRotatedString(String s1,String s2){
        if(s1.length() != s2.length()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append(s1);

        return (isSubstring(sb.toString(),s2) != -1);
    }

    private static int isSubstring(String s1,String s2){
        return s1.indexOf(s2);
    }
}