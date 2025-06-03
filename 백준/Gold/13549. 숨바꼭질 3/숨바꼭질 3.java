

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;

    static boolean[] visited;
    static int[] distance;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        distance = new int[100001];

        bfs(n, k);

        System.out.println(distance[k]);
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // +1
            int nx = now + 1;
            if (0 <= nx && nx < 100001) {
                if (!visited[nx] || distance[nx] > distance[now] + 1) {
                    distance[nx] = distance[now] + 1;
                    visited[nx] = true;
                    queue.add(nx);
                }
            }

            // -1
            nx = now - 1;
            if (0 <= nx && nx < 100001) {
                if (!visited[nx] || distance[nx] > distance[now] + 1) {
                    distance[nx] = distance[now] + 1;
                    visited[nx] = true;
                    queue.add(nx);
                }
            }

            // *2
            nx = now * 2;
            if (0 <= nx && nx < 100001) {
                if (!visited[nx] || distance[nx] > distance[now]) {
                    distance[nx] = distance[now];
                    visited[nx] = true;
                    queue.add(nx);
                }
            }
        }
    }
}
