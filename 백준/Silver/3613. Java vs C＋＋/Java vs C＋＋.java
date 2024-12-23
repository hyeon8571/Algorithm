import java.io.*;
import java.util.*;

public class Main {
    public static void main (String [] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int n = str.length();

        int i = 0;

        ArrayList<Character> list = new ArrayList<>();

        int post = 0; // 1 -> _, 2 -> 대문자

        while (i < n) {
            char c = str.charAt(i);

            if (i == 0 && c == '_') {
                System.out.println("Error!");
                return;
            }

            if (i == 0 && Character.isUpperCase(c)) {
                System.out.println("Error!");
                return;
            }

            if (c == '_') {
                if (post == 2) {
                    System.out.println("Error!");
                    return;
                }

                if (i >= n-1) {
                    System.out.println("Error!");
                    return;
                }

                i += 1;
                char cr = str.charAt(i);

                if (cr == '_') {
                    System.out.println("Error!");
                    return;
                }
                
                if (Character.isUpperCase(cr)) {
                    System.out.println("Error!");
                    return;
                }

                list.add(Character.toUpperCase(cr));
                post = 1;
                i++;


            } else if (Character.isUpperCase(c)) {
                if (post == 1) {
                    System.out.println("Error!");
                    return;
                }


                list.add('_');
                list.add(Character.toLowerCase(c));
                i++;
                post = 2;
            } else {
                list.add(c);
                i++;
            }
        }

        for (Character character : list) {
            System.out.print(character);
        }
    }
}
