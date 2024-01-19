package boj.array;

import java.util.Scanner;

public class Boj_10808 {
    public static void main(String[] args) {
        int[] alphabet = new int[26];

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int n = ch - 97;
            alphabet[n]++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alphabet[i]);
            System.out.print(" ");
        }

    }
}
