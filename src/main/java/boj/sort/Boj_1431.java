package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Boj_1431 {

    static class SerialNum implements Comparable<SerialNum>{
        String content;
        int length;

        public SerialNum(String content, int length) {
            this.content = content;
            this.length = length;
        }


        @Override
        public int compareTo(SerialNum o) {
            if (this.length - o.length > 0) {
                return 1; // o.length가 더 짧으므로 o 를 앞으로
            } else if (length == o.length) {
                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < length; i++) {
                    if ('0' <= content.charAt(i) && content.charAt(i) <= '9') {
                        sum1 += content.charAt(i) - '0';
                    }

                    if ('0' <= o.content.charAt(i) && o.content.charAt(i) <= '9') {
                        sum2 += o.content.charAt(i) - '0';
                    }
                }

                if (sum1 > sum2) {
                    return 1;
                } else if (sum1 < sum2) {
                    return -1;
                } else {
                    return content.compareTo(o.content);
                }

            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<SerialNum> serialList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int cnt = 0;

            String str = br.readLine();
            cnt = str.length();

            serialList.add(new SerialNum(str, cnt));
        }

        Collections.sort(serialList);

        for (int i = 0; i < N; i++) {
            System.out.println(serialList.get(i).content);
        }
    }
}
