package boj.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Character> list = new LinkedList<>();

        String[] strArr = new String[n];

        int index = 0;

        for (int i = 0; i < n; i++) {
            strArr[i] = br.readLine();

            for (int j = 0; j < strArr[i].length(); i++) {
                list.add(strArr[i].charAt(j));
            }

            for (int j = 0; j < strArr[j].length(); j++) {

                if (list.get(j) == '<') {

                }

            }

        }
    }
}
