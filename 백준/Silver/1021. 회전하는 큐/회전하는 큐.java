import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!deque.isEmpty()) {
                if (deque.getFirst() == num) {
                    deque.pollFirst();
                } else {
                    int idx = deque.indexOf(num);
                    int half = deque.size() / 2;

                    if (idx > half) {
                        while (deque.getFirst() != num) {
                            deque.addFirst(deque.removeLast());
                            cnt++;
                        }
                        deque.pollFirst();
                    } else {
                        // 왼쪽 이동
                        while (deque.getFirst() != num) {
                            deque.addLast(deque.removeFirst());
                            cnt++;

                        }
                        deque.pollFirst();
                    }
                }

            } else {
                break;
            }

        }
        System.out.println(cnt);
    }
}
