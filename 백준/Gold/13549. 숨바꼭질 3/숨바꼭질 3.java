import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    static int N, K;

    static int[] dx = new int[] {-1, 1};

    static int[] grid;

    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        grid = new int[100001];
        visited = new int[100001];

        bfs(N);

        System.out.println(visited[K] - 1);
    }

    public static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[start] = 1;
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer now = queue.pollFirst();

            for (int i = 0; i < 3; i++) {
                int nx = now;
                if (i == 2) {
                    nx = now + now;
                } else {
                    nx = now + dx[i];
                }

                if (0  <= nx && nx <= 100000) {
                    if (visited[nx] == 0 && i != 2)  {
                        visited[nx] = visited[now] + 1;
                        queue.add(nx);
                    } else if (visited[nx] != 0 && i != 2) {
                        if (visited[nx] > visited[now] + 1) {
                            visited[nx] = visited[now] + 1;
                            queue.add(nx);
                        }
                    } else if (visited[nx] == 0 && i == 2) {
                        visited[nx] = visited[now];
                        queue.add(nx);
                    } else if (visited[nx] != 0 && i == 2) {
                        if (visited[nx] > visited[now]) {
                            visited[nx] = visited[now];
                            queue.add(nx);
                        }
                    }
                }

            }
        }
    }
}
