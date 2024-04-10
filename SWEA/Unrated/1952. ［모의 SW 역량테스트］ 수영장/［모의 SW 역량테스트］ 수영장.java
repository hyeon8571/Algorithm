
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[] price;

    static int[] plan;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            price = new int[4];

            result = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            plan = new int[12];

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);

            if (result > price[3]) {
                result = price[3];
            }

            System.out.println("#" + t + " " + result);

        }
    }

    public static void dfs(int start, int money) {
        if (start >= 12) {

            if (money < result) {
                result = money;
            }
            return;
        }

        if (plan[start]*price[0] > price[1]) {
            dfs(start+1,money + price[1]);
        } else {
            dfs(start+1,money + plan[start]*price[0]);
        }

        dfs(start+3, money + price[2]);
    }
}
