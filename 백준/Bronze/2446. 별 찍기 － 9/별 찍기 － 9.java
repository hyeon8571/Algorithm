import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2 * (N - i) - 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 1; i <= N-1; i++) {

            for (int j = 0; j < N-i-1; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < 2*i + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
