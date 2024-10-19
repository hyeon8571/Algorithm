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
            pq.add(new Time(Integer.parseInt(st.nextToken()), true));
            pq.add(new Time(Integer.parseInt(st.nextToken()), false));
        }

        int cnt = 0;
        int result = 0;

        while (!pq.isEmpty()) {
            Time time = pq.poll(); // 오름차순 정렬로 가장 작은게 시간이 가장 작은게 나옴

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
        int time;
        boolean isStart;

        public Time(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Time o) {
            return this.time - o.time;
        }
    }
}
