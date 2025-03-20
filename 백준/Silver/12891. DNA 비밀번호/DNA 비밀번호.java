import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String str = br.readLine();

        Character[] arr = new Character[S];

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S; i++) {
            arr[i] = str.charAt(i);
        }

        // A C G T
        st = new StringTokenizer(br.readLine());

        int[] num = new int[4];
        for (int i = 0; i < 4; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        int end = P-1;
        int start = 0;

        map.put('A', 0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);

        while (end < S) {

            if (start == 0) {
                for (int i = 0; i < P; i++) {
                    if (arr[i] == 'A') {
                        map.put(arr[i], map.get('A')+1);
                    } else if (arr[i] == 'C') {
                        map.put(arr[i], map.get('C')+1);
                    } else if (arr[i] == 'G') {
                        map.put(arr[i], map.get('G')+1);
                    } else if (arr[i] == 'T') {
                        map.put(arr[i], map.get('T')+1);
                    }

                }
            } else {
                map.put(arr[start-1], map.get(arr[start-1])-1);

                if (map.get(arr[end]) != null) {
                    map.put(arr[end], map.get(arr[end])+1);
                } else {
                    map.put(arr[end], 1);
                }
            }

            if (map.get('A') >= num[0] && map.get('C') >= num[1] && map.get('G') >= num[2] && map.get('T') >= num[3]) {
                result++;
            }

            start++;
            end++;

        }

        System.out.println(result);
    }
}
