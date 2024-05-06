import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {

    static int[][] grid;

    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 1; t <= 10; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            grid = new int[101][101];

            visited = new int[101];

            int length = Integer.parseInt(st.nextToken());

            int startNode = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < length / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                grid[from][to] = 1;
            }

            int result = bfs(startNode);

            System.out.println("#" + t + " " + result);

        }
    }

    public static int bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[start] = 1;

        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();

            for (int i = 0; i < 101; i++) {
                if (grid[now][i] == 1 && visited[i] == 0) {
                    queue.add(i);
                    visited[i] = visited[now] + 1;
                }
            }
        }

        int max = 0;

        int cnt = 0;

        for (int i = 0; i < 101; i++) {
            if (visited[i] != 0) {
                if (max <= visited[i]) {
                    max = visited[i];
                }
            }
        }

        for (int i = 0; i < 101; i++) {
            if (visited[i] == max) {
                cnt = i;
            }
        }

        return cnt;

    }
}
