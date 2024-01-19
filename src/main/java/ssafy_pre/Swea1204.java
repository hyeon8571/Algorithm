package ssafy_pre;

import java.io.IOException;
import java.util.Scanner;


public class Swea1204 {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 1; i <= T; i++)
        {
            int t = sc.nextInt();

            int[] score = new int[1000];
            for(int j = 0; j < 1000; j++) {
                score[sc.nextInt()]++;
            }

            int result = 0;
            for(int j = 0; j < 1000; j++) {
                if(score[j] >= score[result]) {
                    result = j;
                }
            }

            System.out.printf("#%d %d\n", i, result);
        }
    }
}