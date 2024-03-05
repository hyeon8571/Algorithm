package boj.samsungA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Swea_4013 {

    static LinkedList<Integer> deque1;
    static LinkedList<Integer> deque2;
    static LinkedList<Integer> deque3;
    static LinkedList<Integer> deque4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {

            deque1 = new LinkedList<>();
            deque2 = new LinkedList<>();
            deque3 = new LinkedList<>();
            deque4 = new LinkedList<>();

            int K = Integer.parseInt(br.readLine());

            StringTokenizer st = null;

            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 8; j++) {
                    if (i == 0) {
                        deque1.add(Integer.parseInt(st.nextToken()));
                    } else if (i == 1) {
                        deque2.add(Integer.parseInt(st.nextToken()));
                    } else if (i == 2) {
                        deque3.add(Integer.parseInt(st.nextToken()));
                    } else if (i == 3){
                        deque4.add(Integer.parseInt(st.nextToken()));
                    }
                }

            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int rotateNum = Integer.parseInt(st.nextToken());

                int dir = Integer.parseInt(st.nextToken());

                rotate(rotateNum, dir);
            }

            int score = 0;

            if (deque1.get(0) == 1) score += 1;
            if (deque2.get(0) == 1) score += 2;
            if (deque3.get(0) == 1) score += 4;
            if (deque4.get(0) == 1) score += 8;

            System.out.println("#" + t + " " + score);
        }
    }

    public static void rotate(int rotateNum, int dir) {

        if (rotateNum == 1) {
            if (dir == 1) {
                if (deque1.get(2) != deque2.get(6)) {

                    if (deque2.get(2) != deque3.get(6)) {

                        if (deque3.get(2) != deque4.get(6)) {
                            deque4.offerLast(deque4.pollFirst()); // 반시계
                        }

                        deque3.offerFirst(deque3.pollLast()); // 시계
                    }

                    deque2.offerLast(deque2.pollFirst()); // 반시계

                }
                deque1.offerFirst(deque1.pollLast()); // 시계

            } else {

                if (deque1.get(2) != deque2.get(6)) {

                    if (deque2.get(2) != deque3.get(6)) {

                        if (deque3.get(2) != deque4.get(6)) {
                            deque4.offerFirst(deque4.pollLast()); // 시계
                        }

                        deque3.offerLast(deque3.pollFirst()); // 반시계
                    }

                    deque2.offerFirst(deque2.pollLast()); // 시계

                }

                deque1.offerLast(deque1.pollFirst()); // 반시계


            }
        } else if (rotateNum == 2) {

            if (dir == 1) {

                if (deque2.get(6) != deque1.get(2)) {
                    deque1.offerLast(deque1.pollFirst()); // 반시계
                }

                if (deque2.get(2) != deque3.get(6)) {

                    if (deque3.get(2) != deque4.get(6)) {
                        deque4.offerFirst(deque4.pollLast()); // 시계
                    }

                    deque3.offerLast(deque3.pollFirst()); // 반시계
                }

                deque2.offerFirst(deque2.pollLast()); // 시계

            } else {

                if (deque2.get(6) != deque1.get(2)) {
                    deque1.offerFirst(deque1.pollLast()); // 시계
                }

                if (deque2.get(2) != deque3.get(6)) {

                    if (deque3.get(2) != deque4.get(6)) {
                        deque4.offerLast(deque4.pollFirst()); // 반시계
                    }

                    deque3.offerFirst(deque3.pollLast()); // 시계
                }

                deque2.offerLast(deque2.pollFirst()); // 반시계

            }

        } else if (rotateNum == 3) {
            if (dir == 1) {

                if (deque3.get(6) != deque2.get(2)) {

                    if (deque2.get(6) != deque1.get(2)) {
                        deque1.offerFirst(deque1.pollLast()); // 시계
                    }

                    deque2.offerLast(deque2.pollFirst()); // 반시계
                }

                if (deque3.get(2) != deque4.get(6)) {
                    deque4.offerLast(deque4.pollFirst()); // 반시계
                }

                deque3.offerFirst(deque3.pollLast()); // 시계

            } else {

                if (deque3.get(6) != deque2.get(2)) {

                    if (deque2.get(6) != deque1.get(2)) {
                        deque1.offerLast(deque1.pollFirst()); // 반시계
                    }

                    deque2.offerFirst(deque2.pollLast()); // 시계
                }

                if (deque3.get(2) != deque4.get(6)) {
                    deque4.offerFirst(deque4.pollLast()); // 시계
                }

                deque3.offerLast((deque3.pollFirst())); // 반시계


            }
        } else if (rotateNum == 4) {
            if (dir == 1) {

                if (deque4.get(6) != deque3.get(2)) {

                    if (deque3.get(6) != deque2.get(2)) {

                        if (deque2.get(6) != deque1.get(2)) {
                            deque1.offerLast(deque1.pollFirst()); // 반시계
                        }

                        deque2.offerFirst(deque2.pollLast()); // 시계
                    }

                    deque3.offerLast(deque3.pollFirst()); // 반시계
                }

                deque4.offerFirst(deque4.pollLast()); // 시계


            } else {

                if (deque4.get(6) != deque3.get(2)) {

                    if (deque3.get(6) != deque2.get(2)) {

                        if (deque2.get(6) != deque1.get(2)) {
                            deque1.offerFirst(deque1.pollLast()); // 시계
                        }

                        deque2.offerLast(deque2.pollFirst()); // 반시계
                    }

                    deque3.offerFirst(deque3.pollLast()); // 시계
                }

                deque4.offerLast(deque4.pollFirst()); // 반시계

            }
        }
    }
}
