package boj.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18808 {

    static int[][] grid;

    static int[][] stickerGrid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int stickerN = Integer.parseInt(st.nextToken());

            int stickerM = Integer.parseInt(st.nextToken());

            stickerGrid = new int[stickerN][stickerM];

            for (int k = 0; k < stickerN; k++) {
                st = new StringTokenizer(br.readLine());
                for (int l = 0; l < stickerM; l++) {
                    stickerGrid[k][l] = Integer.parseInt(st.nextToken());
                }
            }



        }
    }
}
