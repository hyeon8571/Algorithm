
import java.io.*;
import java.util.*;

public class Main {

    static class Place {
        int x, time;

        public Place(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }


    static int N, K;
    static int[] map;
    static boolean[] visited;
    static int[] distance;
    static int result = Integer.MAX_VALUE;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[100001];
        visited = new boolean[100001];
        distance = new int[100001];

        bfs(N);

        System.out.println(result);
        System.out.println(cnt);
    }

    public static void bfs(int startX) {

        int[] dx = new int[] {-1, 1, 2};

        Queue<Place> queue = new ArrayDeque<>();
        queue.add(new Place(startX, 0));
        visited[startX] = true;

        while (!queue.isEmpty()) {
            Place now = queue.poll();

            if (now.time > result) {
                return;
            }

            if (now.x == K) {
                if (result > now.time) {
                    result = now.time;
                    cnt++;
                    continue;
                } else if (result == now.time) {
                    cnt++;
                    continue;
                }
            }

            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i <= 1) {
                    nx = now.x + dx[i];
                } else {
                    nx = now.x * 2;
                }


                if (0 <= nx && nx < 100001) {
                    if (!visited[nx]) {
                        queue.add(new Place(nx, now.time + 1));
                        distance[nx] = now.time+1;
                        visited[nx] = true;
                    } else {
                        if (now.time + 1 <= distance[nx]) {
                            distance[nx] = now.time + 1;
                            queue.add(new Place(nx, now.time + 1));
                        }
                    }
                }
            }
        }
    }
}
