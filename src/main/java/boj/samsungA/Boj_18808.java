package boj.samsungA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18808 {

    static int[][] grid;

    static int N, M, sN, sM, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());

        grid = new int[N][M];


        for (int i = 0; i < K; i++) {

            cnt = 0;

            st = new StringTokenizer(br.readLine());

            sN = Integer.parseInt(st.nextToken());

            sM = Integer.parseInt(st.nextToken());

            int[][] sticker = new int[sN][sM];

            // 스티커 입력
            for (int j = 0; j < sN; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < sM; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                    if (sticker[j][k] == 1) {
                        cnt++;
                    }
                }
            }

            // 4방향으로 회전 시키면서 스티커를 붙일 수 있는지 확인
            for (int j = 0; j < 4; j++) {
                // 스티커를 붙일 수 있으면 붙이고 반복 탈출
                if (canSticker(sticker)) {
                    break;
                }
                sticker = spinSticker(sticker);

                int temp = sM;
                sM = sN;
                sN = temp;
            }
        }

        int res = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }



        System.out.println(res);
    }

    // 스티커를 붙일 수 있는지 확인
    public static boolean canSticker(int[][] sticker) {

        int can = 0;

        int[][] newGrid;

        for (int i = 0; i <= N - sN; i++) {
            for (int j = 0; j <= M - sM; j++) {

                newGrid = new int[N][M];
                for (int k = 0; k < sN; k++) {
                    for (int l = 0; l < sM; l++) {
                        if (grid[i + k][j + l] == 0 && sticker[k][l] == 1) {
                            newGrid[i+k][j+l] = 1;
                            can++;
                        }

                        if (can == cnt) {
                            attach(newGrid);
                            return true;
                        }

                    }
                }
                can = 0;
            }
        }

        return false;
    }

    public static void attach(int[][] newGrid) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (newGrid[i][j] == 1) {
                    grid[i][j] = 1;
                }
            }
        }

    }

    public static int[][] spinSticker(int[][] sticker) {

        int[][] newSticker = new int[sM][sN];

        for (int i = 0; i < sN; i++) {
            for (int j = 0; j < sM; j++) {
                newSticker[j][sN-i-1] = sticker[i][j];
            }
        }

        return newSticker;
    }

}
