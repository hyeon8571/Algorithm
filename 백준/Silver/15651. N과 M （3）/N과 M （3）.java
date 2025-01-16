import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int M;
    static int[] choice;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        choice = new int[M];


        duplePermutation(0);

        System.out.println(sb);
    }

    public static void duplePermutation(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(choice[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            choice[depth] = i;
            duplePermutation(depth+1);
        }
    }
}
