package boj.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_11652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N  = Integer.parseInt(br.readLine());

        Map<Long, Integer> cardMap = new HashMap<>();

        for (int i = 0; i < N; i++) {

            long value = Long.parseLong(br.readLine());

            if (cardMap.containsKey(value)) {
                cardMap.put(value, cardMap.get(value) + 1);
            } else {
                cardMap.put(value, 1);
            }

        }

        List<Long> keySet = new ArrayList<>(cardMap.keySet());

        keySet.sort(new Comparator<Long>() {

            @Override
            public int compare(Long o1, Long o2) {
                 if (cardMap.get(o1) - cardMap.get(o2) > 0) {
                     return -1;
                 } else if (cardMap.get(o1).equals(cardMap.get(o2))) {
                     if (o1 > o2) {
                         return 1;
                     } else {
                         return -1;
                     }
                 } else {
                     return 1;
                 }
            }
        });

        System.out.println(keySet.get(0));

    }
}
