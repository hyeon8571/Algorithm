package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Queue;

public class boj_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        int[] arr = new int[n];

        int idx = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch (order) {
                case "push" : {
                    int k = Integer.parseInt(st.nextToken());
                    queue.offer(k);
                    arr[idx++] = k;
                    break;
                }

                case "pop" : {
                    if (!queue.isEmpty()) {
                        sb.append(queue.poll());
                        sb.append("\n");
                        break;
                    } else {
                        sb.append(-1);
                        sb.append("\n");
                        break;
                    }
                }

                case "size" : {
                    sb.append(queue.size());
                    sb.append("\n");
                    break;
                }

                case "empty" : {
                    if (queue.isEmpty()) {
                        sb.append(1);
                        sb.append("\n");
                        break;
                    }
                    sb.append(0);
                    sb.append("\n");
                    break;
                }

                case "front" : {
                    if (!queue.isEmpty()) {
                        sb.append(queue.peek());
                        sb.append("\n");
                        break;
                    } else {
                        sb.append(-1);
                        sb.append("\n");
                        break;
                    }
                }

                case "back" : {
                    if (!queue.isEmpty()) {
                        sb.append(arr[idx - 1]);
                        sb.append("\n");
                        break;
                    } else {
                        sb.append(-1);
                        sb.append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
