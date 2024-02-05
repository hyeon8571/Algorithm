package boj.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Boj_1697 {

    static int N;
    static int K;

    static ArrayDeque<Integer> queue = new ArrayDeque<>();

    static boolean[] visited;

    static int[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];

        distance = new int[100001];

        queue.add(N);

        visited[N] = true;

        if (N == K) {
            System.out.print(0);
            return;
        }

        System.out.print(BFS(N));


    }

    public static int BFS(int n) {

        while (!queue.isEmpty()) {

            int nowX = queue.pollFirst();

            int[] dx = new int[]{-1, 1, nowX};

            for (int i = 0; i < 3; i++) {

                int nx = nowX + dx[i];

                if (0 <= nx && nx <= 100000) {
                    if (nx == K) {
                        return distance[nowX] + 1;
                    } else {
                        if (!visited[nx]) {
                            queue.add(nx);
                            visited[nx] = true;
                            distance[nx] = distance[nowX] + 1;
                        }
                    }

                }


            }
        }
        return 0;

    }
}