import java.io.*;
import java.util.*;

public class Main {

    public static class Place {
        int from;
        int to;

        public Place(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static int[] distance = new int[101];
    public static List<Place> addr = null;
    public static List<Place> snake = null;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        addr = new ArrayList<>();
        snake = new ArrayList<>();

        // 사다리 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            addr.add(new Place(from, to));
        }

        // 뱀 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            snake.add(new Place(from, to));
        }

        bfs();

        System.out.println(distance[100]);
    }

    public static void bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int nx = now + i;

                // 사다리 체크
                for (int j = 0; j < addr.size(); j++) {
                    if (nx == addr.get(j).from) {
                        nx = addr.get(j).to;
                    }
                }

                // 뱀 체크
                for (int j = 0; j < snake.size(); j++) {
                    if (nx == snake.get(j).from) {
                        nx = snake.get(j).to;
                    }
                }


                if (nx <= 100) {
                    if (distance[nx] == 0) {
                        distance[nx] = distance[now] + 1;
                        queue.add(nx);
                    } else {
                        if (distance[nx] > distance[now] + 1) {
                            distance[nx] = distance[now] + 1;
                            queue.add(nx);
                        }
                    }
                }


            }
        }
    }
}
