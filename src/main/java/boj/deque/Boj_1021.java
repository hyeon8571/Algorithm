package boj.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalNum = Integer.parseInt(st.nextToken()); // 10

        int num = Integer.parseInt(st.nextToken()); // 3

        int findIdx = 0;

        int result = 0;

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];

        int loc = 0;

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 10 9 8 7 6 5 4 3 2 1
        }

        for (int i = 1; i <= totalNum; i++) {
            deque.add(i);
        }

        while(arr[num-1] != 0) {
            if (arr[findIdx] == deque.peekFirst()) {
                deque.pollFirst();
                arr[findIdx] = 0;
                findIdx++;
            } else {
                while(arr[findIdx] != deque.peekFirst()) {
                    if (deque.indexOf(arr[findIdx])  > deque.size() / 2) {
                        deque.offerFirst(deque.pollLast());
                        result++;
                    } else {
                        deque.offerLast(deque.pollFirst());
                        result++;
                    }
                }

            }
        }
        System.out.print(result);
    }
}
