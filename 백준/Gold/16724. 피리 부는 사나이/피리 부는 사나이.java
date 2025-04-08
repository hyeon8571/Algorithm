
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static char[][] grid;
    static boolean[][] visited;
    static boolean[][] cycle;
    static int result;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grid = new char[r][c];
        visited = new boolean[r][c];
        cycle = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(result);

    }

    public static void dfs(int startY, int startX) {
        visited[startY][startX] = true;

        int nx = startX;
        int ny = startY;

        if (grid[startY][startX] == 'D') {
            ny += 1;
        }

        if (grid[startY][startX] == 'L') {
            nx -= 1;
        }

        if (grid[startY][startX] == 'R') {
            nx += 1;
        }

        if (grid[startY][startX] == 'U') {
            ny -= 1;
        }

        if (!visited[ny][nx]) { // 방문하지 않았다면 계속 진행
            dfs(ny, nx);
        } else { // 방문했다면 사이클
            if (!cycle[ny][nx]) { // 사이클 검사
                result++;
            }
        }

        cycle[startY][startX] = true;

    }
}
