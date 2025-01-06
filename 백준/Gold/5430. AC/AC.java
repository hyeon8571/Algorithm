import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine()); // 숫자 개수
            String arr = br.readLine(); // 입력 받은 배열 형태의 String

            Deque<Integer> deque = new ArrayDeque<>();
            arr = arr.replace("[", "");
            arr = arr.replace("]", "");

            String[] strArr = arr.split(",");

            if (!strArr[0].isEmpty()) {
                for (int j = 0; j < strArr.length; j++) {
                    deque.add(Integer.parseInt(strArr[j]));
                }
            }
            boolean reverse = false; // 뒤집지 않음

            for (int k = 0; k < command.length(); k++) {
                char cmd = command.charAt(k);

                if (cmd == 'R') {
                    reverse = !reverse; // 논리적 뒤집기
                    // 실제 뒤집는 코드
//                    int[] temp = new int[deque.size()];
//                    for (int h = 0; h < temp.length; h++) {
//                        temp[h] = deque.pollLast();
//                    }
//
//                    for (int h = 0; h < temp.length; h++) {
//                        deque.addLast(temp[h]);
//                    }
                }

                if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        break;
                    } else {
                        if (reverse) {
                            deque.removeLast();
                        } else {
                            deque.removeFirst();
                        }
                    }
                }

                if (k == command.length()-1) {
                    sb.append("[");

                    int d = deque.size();
                    if (reverse) {
                        for (int j= d; j > 0; j--) {
                            if (j != 1) {
                                sb.append(deque.pollLast()).append(",");
                            } else {
                                sb.append(deque.pollLast());
                            }

                        }
                    } else {
                        for (int j= 0; j < d; j++) {
                            if (j != d -1) {
                                sb.append(deque.pollFirst()).append(",");
                            } else {
                                sb.append(deque.pollFirst());
                            }

                        }
                    }
                    sb.append("]");

                    System.out.println(sb);
                }

            }

        }
    }
}
