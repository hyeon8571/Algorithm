
import java.io.*;
import java.util.*;

public class Main {

    static String word;
    static Map<Character, Integer> wordMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        word = arr[0];
        wordMap = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            wordMap.put(word.charAt(i), wordMap.getOrDefault(word.charAt(i), 0) + 1);
        }

        int count = 0;
        for (int i = 1; i < N; i++) {
            if (check(arr[i])) {
                //System.out.println(arr[i]);
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean check(String s) {

        if (Math.abs(word.length() - s.length()) >= 2) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 길이가 같으면 변경이 가능
        if (s.length() == word.length()) {
            // 방법 1: 기존 로직 수정 - 각 문자별 차이의 총합 계산
            int checkCount = 0;
            Set<Character> allChars = new HashSet<>();
            allChars.addAll(wordMap.keySet());
            allChars.addAll(map.keySet());

            for (Character key : allChars) {
                int a = wordMap.getOrDefault(key, 0);
                int b = map.getOrDefault(key, 0);
                checkCount += Math.abs(a - b);
            }

            // 길이가 같을 때는 차이가 0(완전히 같음) 또는 2(한 글자만 다름)여야 함
            return checkCount == 0 || checkCount == 2;
        }

        if (s.length() > word.length()) {
            Iterator<Character> iter = map.keySet().iterator();
            int checkCount = 0;
            while (iter.hasNext()) {
                Character key = iter.next();
                int a = map.get(key);
                int b = wordMap.getOrDefault(key, 0);
                checkCount += Math.abs(a - b);
            }
            if (checkCount == 1) {
                return true;
            }
        }

        if (s.length() < word.length()) {
            Iterator<Character> iter = wordMap.keySet().iterator();
            int checkCount = 0;
            while (iter.hasNext()) {
                Character key = iter.next();
                int a = wordMap.get(key);
                int b = map.getOrDefault(key, 0);
                checkCount += Math.abs(a - b);
            }
            if (checkCount == 1) {
                return true;
            }
        }

        return false;
    }

}
