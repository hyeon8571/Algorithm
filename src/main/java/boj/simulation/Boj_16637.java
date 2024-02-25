package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_16637 {

    static Character[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i);
        }


    }

    public static void calculate() {


    }
}
