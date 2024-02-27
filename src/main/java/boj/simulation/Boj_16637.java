package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_16637 {

    static Character[] arr;

    static List<Character> operatorList = new ArrayList<>();

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();

        arr = new Character[N];

        for (int i = 0; i < N; i++) {
            arr[i] = str.charAt(i);

            if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*') {
                operatorList.add(arr[i]);
            }
        }

        visited = new boolean[operatorList.size()];


        subset(0);

    }

    public static void calculate() {

    }

    // 괄호를 추가 할 연산자 선택
    public static void subset(int depth, int cnt) {
        if (depth == cnt) {
            for (int i = 0; i < operatorList.size(); i++) {
                if (visited[i]) {
                    System.out.print(operatorList.get(i) + " ");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();

            return;
        }

        visited[depth] = true;
        subset(depth + 1);
        visited[depth] = false;
        subset(depth + 1);
    }
}
