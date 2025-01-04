import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }
        int cursor = K - 1;
//        while (list.size() > 1) {
//            if (cursor > list.size() -1) {
//                cursor -= list.size();
//            }
//
//            sb.append(list.get(cursor));
//            list.remove(cursor);
//            sb.append(',');
//            sb.append(' ');
//
//            cursor += K-1;
//            if (cursor > list.size()-1) {
//                cursor -= list.size();
//            }
//        }
//        sb.append(list.get(0));
//        sb.append('>');
//        System.out.println(sb);
//    }
        while (list.size() > 1) {
            if (cursor > list.size()-1) {
                cursor = cursor % list.size();
            }
            sb.append(list.get(cursor));
            list.remove(cursor);
            sb.append(',');
            sb.append(' ');
            cursor += K-1;
        }
        sb.append(list.get(0));
        sb.append('>');
        System.out.println(sb);
    }
}
