import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

//        for (int i = 0; i < n; i++) {
//            int cursor = 0;
//            List<Character> list = new LinkedList<>();
//            for (int j = 0; j < arr[i].length(); j++) {
//                if (arr[i].charAt(j) == '<') {
//                    if (cursor >= 1) {
//                        cursor -= 1;
//                    }
//                } else if (arr[i].charAt(j) == '>') {
//                    cursor += 1;
//                    if (cursor > list.size()) {
//                        cursor = list.size();
//                    }
//                } else if (arr[i].charAt(j) == '-') {
//                    if (cursor != 0) {
//                        list.remove(cursor-1);
//                        cursor -= 1;
//                    }
//                } else {
//                    if (list.isEmpty()) {
//                        list.add(arr[i].charAt(j));
//                        cursor++;
//                    } else if (cursor == list.size()) {
//                        list.add(arr[i].charAt(j));
//                        cursor++;
//                    } else {
//                        list.add(cursor, arr[i].charAt(j));
//                        cursor++;
//                    }
//                }
//            }
//
//            for (int h = 0; h < list.size(); h++) {
//                sb.append(list.get(h));
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);



        for (int i = 0; i < n; i++) {
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();
            for (int j = 0; j < arr[i].length(); j++) {
                char c = arr[i].charAt(j);

                if (c == '<') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                    }
                } else if (c == '>') {
                    if (iterator.hasNext()) {
                        iterator.next();
                    }
                } else if (c == '-') {
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                } else {
                    iterator.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char s : list) {
                sb.append(s);
            }
            System.out.println(sb);
        }

    }
}
