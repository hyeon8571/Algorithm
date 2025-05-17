import java.util.*;
import java.io.*;

public class Main {

    public static class Fast {
        int start;
        int end;
        int distance;

        public Fast(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    static List<Fast> fastList = new ArrayList<>();
    static int[] visited;
    static int D;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new int[D+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            fastList.add(new Fast(start, end, distance));
        }

        bfs(0);

        System.out.println(visited[D]);
    }

    public static void bfs(int startX) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(startX);
        visited[startX] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            // 1만큼 가는 경우
            int nx = now + 1;
            if (nx <= D) {
                if (visited[nx] == 0 || visited[nx] > visited[now] + 1) {
                    visited[nx] = visited[now] + 1;
                    queue.add(nx);
                }
            }

            // 지름길을 탈 수 있는 경우
            for (int i = 0; i < fastList.size(); i++) {
                if (now == fastList.get(i).start) {
                    if (fastList.get(i).end <= D) {
                        if (visited[fastList.get(i).end] == 0 || visited[fastList.get(i).end] > visited[now] + fastList.get(i).distance) {
                            visited[fastList.get(i).end] = visited[now] + fastList.get(i).distance;
                            queue.add(fastList.get(i).end);
                        }
                    }
                }
            }


        }
    }
}
