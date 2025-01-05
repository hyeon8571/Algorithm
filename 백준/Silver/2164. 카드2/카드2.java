import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        while (deque.size() > 1) {
            deque.pollFirst();
            deque.offerLast(deque.pollFirst());
        }

        System.out.println(deque.poll());
    }
}
