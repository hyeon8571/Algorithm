package boj.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Queue {
    List<Integer> list = new ArrayList<>();

    public Queue() {}

    public void push(int i) {
        list.add(i);
    }

    public int pop() {

        if (list.size() > 0) {
            int n = list.get(0);
            list.remove(0);
            return n;
        } else {
            return -1;
        }
    }

    public int size() {
        return list.size();
    }

    public int empty() {
        if (list.size() == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public int front() {
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return -1;
        }
    }

    public int back() {
        if (list.size() > 0) {
            return list.get(list.size() - 1);
        } else {
            return -1;
        }
    }

}

public class boj_10845 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue queue = new Queue();

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch (order) {
                case "push" : {
                    int k = Integer.parseInt(st.nextToken());
                    queue.push(k);
                    break;
                }

                case "pop" : {
                    sb.append(queue.pop());
                    sb.append("\n");
                    break;
                }

                case "size" : {
                    sb.append(queue.size());
                    sb.append("\n");
                    break;
                }

                case "empty" : {
                    sb.append(queue.empty());
                    sb.append("\n");
                    break;
                }

                case "front" : {
                    sb.append(queue.front());
                    sb.append("\n");
                    break;
                }

                case "back" : {
                    sb.append(queue.back());
                    sb.append("\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}