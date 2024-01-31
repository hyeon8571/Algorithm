package boj.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Boj_5430 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String order = br.readLine(); // 명령

            int arrNum = Integer.parseInt(br.readLine()); // 배열 개수

            String str = br.readLine();

            str = str.replace("[", "");
            str = str.replace("]", "");

            String[] strArr = str.split(",");

            List<Integer> list = new ArrayList<>();

            LinkedList<Integer> dequeue = new LinkedList<>();

            StringBuilder sb = new StringBuilder();

            if (strArr[0] != "") {
                for (int k = 0; k < strArr.length; k++) {
                    list.add(Integer.parseInt(strArr[k]));
                }
            }

            for (int k = 0; k < list.size(); k++) {
                dequeue.offerLast(list.get(k));
            }

            boolean check = true;
            boolean reverse = false;

            for (int k = 0; k < order.length(); k++) {
                if (dequeue.isEmpty()) {
                    if (order.charAt(k) == 'D') {
                        System.out.println("error");
                        check = false;
                        break;
                    }
                } else {
                    if (!reverse) {
                        if (order.charAt(k) == 'D') {
                            dequeue.pollFirst();
                        } else {
                            // reverse
                            reverse = true;
                        }
                    } else {
                        if (order.charAt(k) == 'D') {
                            dequeue.pollLast();
                        } else {
                            // reverse
                            reverse = false;
                        }
                    }

                }
            }

            // 출력
            if (check) {
                sb.append("[");
                while (!dequeue.isEmpty()) {
                    if (!reverse) {
                        if (dequeue.size() != 1) {
                            sb.append(dequeue.pollFirst()).append(",");
                        } else {
                            sb.append(dequeue.pollFirst());
                        }
                    } else {
                        if (dequeue.size() != 1) {
                            sb.append(dequeue.pollLast()).append(",");
                        } else {
                            sb.append(dequeue.pollLast());
                        }
                    }
                }
                sb.append("]\n");
                System.out.print(sb);
            }
        }
    }
}