import java.util.*;
import java.io.*;

public class Main {

    public static class Egg {
        int S, W;

        public Egg(int S, int W) {
            this.S = S;
            this.W = W;
        }
    }

    static int N;
    static Egg[] arr;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Egg(s, w);
        }

        back(0, 0);

        System.out.println(result);

    }

    public static void back(int idx, int cnt) {
        if (idx == N || cnt == N-1) {
            result = Math.max(cnt, result);
            return;
        }

        if (arr[idx].S <= 0) {
            back(idx+1, cnt);
        } else {
            for (int i = 0; i < N; i++) {
                if (i == idx) continue;

                if (arr[i].S > 0) {
                    int check = 0;
                    int leftS = arr[idx].S;
                    int rightS = arr[i].S;
                    arr[idx].S = leftS - arr[i].W;
                    arr[i].S = rightS - arr[idx].W;

                    if (arr[idx].S <= 0) check++;
                    if (arr[i].S <= 0) check++;

                    back(idx+1, cnt+check);
                    arr[idx].S = leftS;
                    arr[i].S = rightS;
                }
            }
        }
    }
}
