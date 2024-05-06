import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static class Place {
        int y, x, dir;

        public Place(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir; // 0 은 가로 1은 세로
        }
    }

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static int[][][] distance;

    static boolean[][][] visited;

    static int N;

    static Character[][] grid;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new Character[N][N];

        distance = new int[2][N][N];

        visited = new boolean[2][N][N];

        int cntB = 0;

        int cntE = 0;

        result = Integer.MAX_VALUE;

        Place prev = new Place(0, 0, -1);

        Place start = new Place(0, 0, -1);

        Place prevE = new Place(0, 0, -1);

        Place end = new Place(0, 0, -1);

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);

                if (grid[i][j] == 'B' && cntB == 0) {
                    prev.y = i;
                    prev.x = j;
                    cntB++;
                } else if (grid[i][j] == 'B' && cntB == 1) {
                    if (prev.x == j) {
                        start.y = i;
                        start.x = j;
                        start.dir = 1;
                        cntB++;
                    } else {
                        start.y = i;
                        start.x = j;
                        start.dir = 0;
                        cntB++;
                    }
                }

                if (grid[i][j] == 'E' && cntE == 0) {
                    prevE.y = i;
                    prevE.x = j;
                    cntE++;
                } else if (grid[i][j] == 'E' && cntE == 1) {
                    if (prevE.x == j) {
                        end.y = i;
                        end.x = j;
                        end.dir = 1;
                        cntE++;
                    } else {
                        end.y = i;
                        end.x = j;
                        end.dir = 0;
                        cntE++;
                    }
                }

            }
        }

        bfs(start.y, start.x, start.dir, end.y, end.x, end.dir);

        if (result != Integer.MAX_VALUE) {
            System.out.println(result);
        } else {
            System.out.println(0);
        }

    }

    public static void bfs(int startY, int startX, int dir, int endY, int endX, int endDir) {
        ArrayDeque<Place> queue = new ArrayDeque<>();

        queue.add(new Place(startY, startX, dir));

        visited[dir][startY][startX] = true;

        while (!queue.isEmpty()) {
            Place now = queue.pollFirst();

            for (int i = 0; i < 5; i++) {

                int nx = now.x;

                int ny = now.y;

                int ndir = now.dir;

                if (i != 4) {
                    ny = now.y + dy[i];
                    nx = now.x + dx[i];


                } else { // 회전

                    boolean flag = true;

                    if (0 <= now.x - 1 && now.x + 1 < N && 0 <= now.y -1 && now.y + 1 < N) {
                        for (int k = now.y - 1; k < now.y + 2; k++) {
                            for (int x = now.x - 1; x < now.x + 2; x++) {
                                if (grid[k][x] == '1') {
                                    flag = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        flag = false;
                    }

                    if (flag) {
                        if (now.dir == 0) {
                            ndir = 1;
                        } else {
                            ndir = 0;
                        }
                    } else {
                        break;
                    }

                }

                if (ndir == 0) { // 가로
                    if (0 <= nx - 1 && nx + 1 < N && 0 <= ny && ny < N) {
                        if (grid[ny][nx - 1] != '1' && grid[ny][nx + 1] != '1' && grid[ny][nx] != '1' && !visited[ndir][ny][nx]) {

                            if (ny == endY && nx == endX && ndir == endDir) {
                                if (result > distance[now.dir][now.y][now.x] + 1) {
                                    result = distance[now.dir][now.y][now.x] + 1;
                                    return;
                                }
                            }

                            visited[ndir][ny][nx] = true;
                            distance[ndir][ny][nx] = distance[now.dir][now.y][now.x] + 1;
                            queue.add(new Place(ny, nx, ndir));

                        }
                    }
                } else { // 세로
                    if (0 <= ny - 1 && ny + 1 < N && 0 <= nx && nx < N) {
                        if (grid[ny - 1][nx] != '1' && grid[ny + 1][nx] != '1' && grid[ny][nx] != '1' && !visited[ndir][ny][nx]) {

                            if (ny == endY && nx == endX && ndir == endDir) {
                                if (result > distance[now.dir][now.y][now.x] + 1) {
                                    result = distance[now.dir][now.y][now.x] + 1;
                                    return;
                                }
                            }

                            visited[ndir][ny][nx] = true;
                            distance[ndir][ny][nx] = distance[now.dir][now.y][now.x] + 1;
                            queue.add(new Place(ny, nx, ndir));
                        }
                    }
                }

            }
        }

    }
}
