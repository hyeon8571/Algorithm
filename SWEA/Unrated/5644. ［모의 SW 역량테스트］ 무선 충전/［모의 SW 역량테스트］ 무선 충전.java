

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    static class Bat {
        int power, who;

        public Bat(int power, int who) {
            this.power = power;
            this.who = who;
        }
    }

    static class Place {
        int y, x;

        public Place(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int M, A;

    static int[] aMove, bMove;

    static List<Bat>[][] grid;

    static boolean[][] visited;

    static int[] dx = new int[] {0, 1, 0, -1};

    static int[] dy = new int[] {-1, 0, 1, 0};

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());

            A = Integer.parseInt(st.nextToken());

            aMove = new int[M];
            bMove = new int[M];

            grid = new List[10][10];

            result = 0;

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    grid[i][j] = new ArrayList<>();
                }
            }

            for (int j = 0; j < 2; j++) {

                st = new StringTokenizer(br.readLine());

                for (int i = 0; i < M; i++) {
                   if (j == 0) {
                       aMove[i] = Integer.parseInt(st.nextToken());
                   } else {
                       bMove[i] = Integer.parseInt(st.nextToken());
                   }

                }
            }

            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;

                int y = Integer.parseInt(st.nextToken()) - 1;

                int range = Integer.parseInt(st.nextToken());

                int power = Integer.parseInt(st.nextToken());

                spread(range, power, y, x, i);

            }

            charge(aMove, bMove);

            System.out.println("#" + t + " " + result);

        }
    }

    public static void spread(int range, int power, int y, int x, int who) {

        visited = new boolean[10][10];

        ArrayDeque<Place> queue = new ArrayDeque<>();

        queue.add(new Place(y, x));

        grid[y][x].add(new Bat(power, who));

        visited[y][x] = true;

        while(!queue.isEmpty()) {

            Place now = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];

                int nx = now.x + dx[i];

                if (0 <= ny && ny < 10 && 0 <= nx && nx < 10) {
                    if (Math.abs(nx - x) + Math.abs(ny - y) <= range && !visited[ny][nx]) {
                        queue.add(new Place(ny, nx));
                        grid[ny][nx].add(new Bat(power, who));
                        visited[ny][nx] = true;
                    }
                }

            }
        }
    }

    public static void charge(int[] aMove, int[] bMove) {

        int aY = 0;

        int aX = 0;

        int bY = 9;

        int bX = 9;

        if (grid[aY][aX].size() == 0 && grid[bY][bX].size() == 0) { // 둘 다 범위 포함 x
            result += 0;
        } else {
            if (grid[aY][aX].size() == 0 && grid[bY][bX].size() != 0) { // b만 포함

                int max = 0;

                for (int i = 0; i < grid[bY][bX].size(); i++) {
                    if (grid[bY][bX].get(i).power > max) {
                        max = grid[bY][bX].get(i).power;
                    }
                }

                result += max;

            } else if (grid[aY][aX].size() != 0 && grid[bY][bX].size() == 0) { // a 만 포함
                int max = 0;

                for (int i = 0; i < grid[aY][aX].size(); i++) {
                    if (grid[aY][aX].get(i).power > max) {
                        max = grid[aY][aX].get(i).power;
                    }
                }

                result += max;

            } else if (grid[aY][aX].size() != 0 && grid[bY][bX].size() != 0) {
                if (grid[aY][aX].size() == 1 && grid[bY][bX].size() == 1) {
                    if (grid[aY][aX].get(0).who == grid[bY][bX].get(0).who) {
                        result += grid[aY][aX].get(0).power;
                    } else {
                        result += grid[aY][aX].get(0).power;;
                        result += grid[bY][bX].get(0).power;;
                    }
                } else if (grid[aY][aX].size() == 1 && grid[bY][bX].size() != 1) {

                    int max = 0;

                    for (int i = 0; i < grid[bY][bX].size(); i++) {

                        int power = 0;

                        if (grid[bY][bX].get(i).who == grid[aY][aX].get(0).who) {
                            power = grid[aY][aX].get(0).power;
                        } else {
                            power = grid[aY][aX].get(0).power + grid[bY][bX].get(i).power;
                        }

                        if (power > max) {
                            max = power;
                        }

                    }

                    result += max;

                } else if (grid[aY][aX].size() != 1 && grid[bY][bX].size() == 1) {
                    int max = 0;

                    for (int i = 0; i < grid[aY][aX].size(); i++) {

                        int power = 0;

                        if (grid[aY][aX].get(i).who == grid[bY][bX].get(0).who) {
                            power = grid[bY][bX].get(0).power;
                        } else {
                            power = grid[bY][bX].get(0).power + grid[aY][aX].get(i).power;
                        }

                        if (power > max) {
                            max = power;
                        }

                    }

                    result += max;
                } else if (grid[aY][aX].size() != 1 && grid[bY][bX].size() != 1) {
                    int max = 0;

                    for (int i  = 0; i < grid[aY][aX].size(); i++) {
                        for (int j = 0; j < grid[bY][bX].size(); j++) {
                            int power = 0;

                            if (grid[aY][aX].get(i).who == grid[bY][bX].get(j).who) {
                                power = grid[aY][aX].get(i).power;
                            } else {
                                power = grid[aY][aX].get(i).power + grid[bY][bX].get(j).power;
                            }

                            if (power > max) {
                                max = power;
                            }

                        }
                    }

                    result += max;
                }
            }
        }

        for (int x = 0; x < aMove.length; x++) {

            if (aMove[x] == 0) {

            }

            if (aMove[x] == 1) {
                aY = aY - 1;
            }

            if (aMove[x] == 2) {
                aX = aX + 1;
            }

            if (aMove[x] == 3) {
                aY = aY + 1;
            }

            if (aMove[x] == 4) {
                aX = aX - 1;
            }

            if (bMove[x] == 0) {

            }

            if (bMove[x] == 1) {
                bY = bY - 1;
            }

            if (bMove[x] == 2) {
                bX = bX + 1;
            }

            if (bMove[x] == 3) {
                bY = bY + 1;
            }

            if (bMove[x] == 4) {
                bX = bX - 1;
            }

            if (grid[aY][aX].size() == 0 && grid[bY][bX].size() == 0) { // 둘 다 범위 포함 x
                result += 0;
            } else {
                if (grid[aY][aX].size() == 0 && grid[bY][bX].size() != 0) { // b만 포함

                    int max = 0;

                    for (int i = 0; i < grid[bY][bX].size(); i++) {
                        if (grid[bY][bX].get(i).power > max) {
                            max = grid[bY][bX].get(i).power;
                        }
                    }

                    result += max;

                } else if (grid[aY][aX].size() != 0 && grid[bY][bX].size() == 0) { // a 만 포함
                    int max = 0;

                    for (int i = 0; i < grid[aY][aX].size(); i++) {
                        if (grid[aY][aX].get(i).power > max) {
                            max = grid[aY][aX].get(i).power;
                        }
                    }

                    result += max;

                } else if (grid[aY][aX].size() != 0 && grid[bY][bX].size() != 0) {
                    if (grid[aY][aX].size() == 1 && grid[bY][bX].size() == 1) {
                        if (grid[aY][aX].get(0).who == grid[bY][bX].get(0).who) {
                            result += grid[aY][aX].get(0).power;
                        } else {
                            result += grid[aY][aX].get(0).power;;
                            result += grid[bY][bX].get(0).power;;
                        }
                    } else if (grid[aY][aX].size() == 1 && grid[bY][bX].size() != 1) {

                        int max = 0;

                        for (int i = 0; i < grid[bY][bX].size(); i++) {

                            int power = 0;

                            if (grid[bY][bX].get(i).who == grid[aY][aX].get(0).who) {
                                power = grid[aY][aX].get(0).power;
                            } else {
                                power = grid[aY][aX].get(0).power + grid[bY][bX].get(i).power;
                            }

                            if (power > max) {
                                max = power;
                            }

                        }

                        result += max;

                    } else if (grid[aY][aX].size() != 1 && grid[bY][bX].size() == 1) {
                        int max = 0;

                        for (int i = 0; i < grid[aY][aX].size(); i++) {

                            int power = 0;

                            if (grid[aY][aX].get(i).who == grid[bY][bX].get(0).who) {
                                power = grid[bY][bX].get(0).power;
                            } else {
                                power = grid[bY][bX].get(0).power + grid[aY][aX].get(i).power;
                            }

                            if (power > max) {
                                max = power;
                            }

                        }

                        result += max;
                    } else if (grid[aY][aX].size() != 1 && grid[bY][bX].size() != 1) {
                        int max = 0;

                        for (int i  = 0; i < grid[aY][aX].size(); i++) {
                            for (int j = 0; j < grid[bY][bX].size(); j++) {
                                int power = 0;

                                if (grid[aY][aX].get(i).who == grid[bY][bX].get(j).who) {
                                    power = grid[aY][aX].get(i).power;
                                } else {
                                    power = grid[aY][aX].get(i).power + grid[bY][bX].get(j).power;
                                }

                                if (power > max) {
                                    max = power;
                                }

                            }
                        }

                        result += max;
                    }
                }
            }

        }
    }
}
