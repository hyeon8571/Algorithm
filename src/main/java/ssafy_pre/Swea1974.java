package ssafy_pre;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea1974 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int[][] arr = new int[9][9];
            boolean check = true;

            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 9; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 0; j < 9; j++) {
                int[] tmp = new int[9];
                for (int k = 0; k < 9; k++) {
                    tmp[arr[j][k] - 1]++;
                }
                for (int l = 0; l < 9; l++) {
                    if (tmp[l] == 0) {
                        check = false;
                        break;
                    }
                }
            }
            for (int j = 0; j < 9; j++) {
                int[] tmp = new int[9];
                for (int k = 0; k < 9; k++) {
                    tmp[arr[k][j] - 1]++;
                }
                for (int l = 0; l < 9; l++) {
                    if (tmp[l] == 0) {
                        check = false;
                        break;
                    }
                    }
                }


            for (int j = 0; j <= 6; j+=3) {
                for (int k = 0; k <=6; k+=3) {
                    int[] tmp = new int[9];
                    int x = j + 3;
                    int y = k + 3;

                    for (int l = j; l < x; l++) {
                        for (int h = k; h < y; h++) {
                            tmp[arr[l][h] -1]++;
                        }
                    }

                    for (int l = 0; l < 9; l++) {
                        if (tmp[l] == 0) {
                            check = false;
                        }
                    }
                }
            }

            if(check) {
                System.out.printf("#%d 1\n", i);
            } else {
                System.out.printf("#%d 0\n", i);
            }

        }
    }
}
