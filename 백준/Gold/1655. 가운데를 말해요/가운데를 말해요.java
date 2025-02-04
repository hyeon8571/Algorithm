import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq1 = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (i == 1) {
                sb.append(x).append("\n");
                pq1.offer(x);
                continue;
            }

            if (i % 2 != 0) {
                pq1.offer(x);
                if (pq1.peek() > pq2.peek()) {
                    int gap1 = pq1.peek();
                    int gap2 = pq2.peek();
                    pq1.poll();
                    pq2.poll();
                    pq2.offer(gap1);
                    pq1.offer(gap2);
                }
                sb.append(pq1.peek()).append("\n");
                continue;

            } else {
                pq2.offer(x);

                if (pq1.peek() > pq2.peek()) {
                    int gap1 = pq1.peek();
                    int gap2 = pq2.peek();
                    pq1.poll();
                    pq2.poll();
                    pq2.offer(gap1);
                    pq1.offer(gap2);
                }
            }

            if (pq1.peek() < pq2.peek()) {
                sb.append(pq1.peek()).append("\n");
            } else {
                sb.append(pq2.peek()).append("\n");
            }

        }
        System.out.println(sb);
    }
}
