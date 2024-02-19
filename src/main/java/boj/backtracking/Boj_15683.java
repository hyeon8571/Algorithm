package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15683 {

    static int N, M;

    static int[][] grid;

    static boolean[][] visited;

    static int num;

    static int result, min;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        visited = new boolean[N][M];

        min = N * M;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (1 <= grid[i][j] && grid[i][j] <= 5) {
                    num++;
                }
            }
        }
        checkCCTV(0);

        System.out.println(min);
    }

    // 1~5 의 값을 찾으면 모든 cctv를 ^ 방향을 보게 설정하고 좌표 변경
    // 가장 마지막에 찾은 cctv 부터 4방향으로 회전시킴
    // 좌표 바꾼걸 철회해야함

    public static void checkCCTV(int cnt) {

        System.out.println("cnt" + cnt);

        if (cnt == num) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (grid[i][j] == 0)  {
                        result++;
                    }
                }
            }
            System.out.println("result" + result);
            if (result < min) {
                min = result;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (1 <= grid[i][j] && grid[i][j] <= 5) {
                    if (!visited[i][j]) {
                        visited[i][j] = true;
                        // ^방향으로 보게 설정하고 좌표 변경
                        playCCTV(grid[i][j], i, j);
                        checkCCTV(cnt + 1);
                        visited[i][j] = false;
                    }

                }
            }
        }
    }

    // 좌표를 실제로 바꾸는게 아니라 #개수를 센다
    public static void playCCTV(int mode, int startY, int startX) {

        for (int i = 0; i < 4; i++) {
            if (mode == 1) {
                int ny = startY;
                int nx = startX;

                while (true) {
                    ny = nx + dy[i];
                    nx = ny + dx[i];

                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (grid[ny][nx] == 6) {
                            break;
                        }

                        grid[ny][nx] = -1;

                    } else {
                        break;
                    }
                }
            } else if (mode == 2) {

                int ny = startY;
                int nx = startX;
                while (true) {
                    ny = ny + dy[i];
                    nx = nx + dx[i];

                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (grid[ny][nx] == 6) {
                            break;
                        }

                        grid[ny][nx] = -1;

                    } else {
                        break;
                    }
                }

                ny = startY;
                nx = startX;

                while (true) {
                    ny = ny + dy[(i + 2) % 4];
                    nx = nx + dx[(i + 2) % 4];

                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (grid[ny][nx] == 6) {
                            break;
                        }

                        grid[ny][nx] = -1;

                    } else {
                        break;
                    }
                }

            } else if (mode == 3) {

                int ny = startY;
                int nx = startX;
                while (true) {
                    ny = ny + dy[i];
                    nx = nx + dx[i];

                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (grid[ny][nx] == 6) {
                            break;
                        }

                        grid[ny][nx] = -1;

                    } else {
                        break;
                    }
                }

                ny = startY;
                nx = startX;

                while (true) {
                    ny = ny + dy[(i + 1) % 4];
                    nx = nx + dx[(i + 1) % 4];

                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (grid[ny][nx] == 6) {
                            break;
                        }

                        grid[ny][nx] = -1;

                    } else {
                        break;
                    }
                }

            } else if (mode == 4) {

                int ny = startY;
                int nx = startX;
                while (true) {
                    ny = ny + dy[i];
                    nx = nx + dx[i];

                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (grid[ny][nx] == 6) {
                            break;
                        }

                        grid[ny][nx] = -1;

                    } else {
                        break;
                    }
                }

                ny = startY;
                nx = startX;

                while (true) {
                    ny = ny + dy[(i + 1) % 4];
                    nx = nx + dx[(i + 1) % 4];

                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (grid[ny][nx] == 6) {
                            break;
                        }

                        grid[ny][nx] = -1;

                    } else {
                        break;
                    }
                }

                ny = startY;
                nx = startX;

                while (true) {
                    ny = ny + dy[(i + 3) % 4];
                    nx = nx + dx[(i + 3) % 4];

                    if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                        if (grid[ny][nx] == 6) {
                            break;
                        }

                        grid[ny][nx] = -1;

                    } else {
                        break;
                    }
                }

            } else if (mode == 5) {


                int ny = startY;
                int nx = startX;

                for (int j = 0; j < 4; j++) {
                    ny = startY;
                    nx =startX;
                    while (true) {
                        ny = ny + dy[j];
                        nx = nx + dx[j];

                        if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                            if (grid[ny][nx] == 6) {
                                break;
                            }

                            grid[ny][nx] = -1;

                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

}
