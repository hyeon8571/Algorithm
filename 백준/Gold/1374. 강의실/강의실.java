import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Time> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.add(new Time(num, start, true));
            pq.add(new Time(num, end, false));
        }

        int cnt = 0;
        int result = 0;

        while (!pq.isEmpty()) {
            Time time = pq.poll();

            if (time.isStart) {
                cnt++;
                result = Math.max(result, cnt);
            } else {
                cnt--;
            }
        }

        System.out.println(result);
    }

    static class Time implements Comparable<Time> {
        int num;
        int time;
        boolean isStart;

        public Time(int num, int time, boolean isStart) {
            this.num = num;
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) {
                return Boolean.compare(this.isStart, o.isStart); // 끝나는 시간이 우선되도록
            }
            return this.time - o.time; // 오름차순 정렬
        }

    }
}
