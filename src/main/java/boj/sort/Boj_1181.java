package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> list = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            int length = str.length();

            list.put(str, length);

        }

       List<String> keyset = new ArrayList<>(list.keySet());

        keyset.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (list.get(o1) - list.get(o2) > 0) {
                    return 1;
                } else if (list.get(o1).equals(list.get(o2))) {
                    if (o1.compareTo(o2) > 0) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        });

        for (String key : keyset) {
            System.out.println(key);
        }


    }
}
