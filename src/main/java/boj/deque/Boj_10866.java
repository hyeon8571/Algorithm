package boj.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_10866 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        Deque<Integer> deque = new LinkedList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            if (order.equals("push_front")) {
                deque.offerFirst(Integer.parseInt(st.nextToken()));
            } else if (order.equals("push_back")) {
                deque.offerLast(Integer.parseInt(st.nextToken()));
            } else if (order.equals("pop_front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollFirst());
                } else {
                    System.out.println(-1);
                }
            } else if (order.equals("pop_back")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.pollLast());
                } else {
                    System.out.println(-1);
                }
            } else if (order.equals("size")) {
                System.out.println(deque.size());
            } else if (order.equals("empty")) {
                if (!deque.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(1);
                }
            } else if (order.equals("front")) {
                if (!deque.isEmpty()) {
                    System.out.println(deque.peekFirst());
                } else {
                    System.out.println(-1);
                }
            } else {
                if (!deque.isEmpty()) {
                    System.out.println(deque.peekLast());
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}