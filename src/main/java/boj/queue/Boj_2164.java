package boj.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Boj_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        // 1 2 3 4 5 6
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.poll();
            int tmp = queue.poll();
            queue.offer(tmp);
        }
        System.out.println(queue.poll());
    }
}
