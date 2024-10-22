import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int p1 = 0;
        int p2 = N-1;

        int sum = Integer.MAX_VALUE;

        int answer1 = arr[p1];
        int answer2 = arr[p2];

        while (p1 < p2) {
            int temp = arr[p1] + arr[p2];
            if (Math.abs(sum) > Math.abs(temp)) {
                sum = temp;
                answer1 = arr[p1];
                answer2 = arr[p2];
            }

            if (temp < 0) {
                p1++;
            } else if (temp > 0){
                p2--;
            } else {
                break;
            }
        }

        System.out.println(answer1 + " " + answer2);
    }
}
