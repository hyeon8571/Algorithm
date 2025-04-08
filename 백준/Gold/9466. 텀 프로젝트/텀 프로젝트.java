import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int result;
    static int[] grid;
    static boolean[] visited;
    static boolean[] cycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            result = 0;
            grid = new int[n+1];
            visited = new boolean[n+1];
            cycle = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                grid[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= n; j++) {
                if (!cycle[j]) {
                    dfs(j);
                }
            }
            System.out.println(n - result);

        }
    }

    public static void dfs(int x) {

        if (visited[x]) {
            cycle[x] = true;
            result++;
        }

        visited[x] = true;
        int next = grid[x];

        if (!cycle[next]) {
            dfs(next);
        }

        visited[x] = false;
        cycle[x] = true;
    }
}
