package ssafy_class;

import java.util.Arrays;
import java.util.Scanner;

// 주사위 던지기(던지는 횟수는 6번 이하라 하자)
public class DiceTest {

    static int N, numbers[];

    static boolean[] isSelected;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 주사위 던지는 횟수
        numbers = new int[N]; // 던지는 주사위 눈 저장할 배열
        int mode = sc.nextInt(); // 주사위 던지기 모드

        switch (mode) {
            case 1: // 중복순열
                dice1(0);
                break;

            case 2: // 순열: 중복 관리
                isSelected = new boolean[7]; // 주사위눈이 사용되었는지 여부 관리
                dice2(0);
                break;

            case 3: // 중복 조합
                dice3(0, 1);
                break;

            case 4: // 조합
                dice4(0, 1);
                break;
        }
    }

    // 중복순열
    private static void dice1(int cnt) { // 주사위 던지기(cnt: 기존까지 던진 주사위 횟수)

        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 1; i <= 6; i++) { // 모든 주사위 눈의 수를 시도(i: 주사위의 눈의 수)
            numbers[cnt] = i;
            dice1(cnt+1);
        }
    }


    private static void dice2(int cnt) { // 주사위 던지기(cnt: 기존까지 던진 주사위 횟수)

        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        for (int i = 1; i <= 6; i++) { // 모든 주사위 눈의 수를 시도(i: 주사위의 눈의 수)
            if (isSelected[i]) {
                continue;
            }
            numbers[cnt] = i;
            isSelected[i] = true;
            dice2(cnt+1);
            isSelected[i] = false;
        }
    }

    // 중복 조합
    private static void dice3(int cnt, int start) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 시작점부터 가능한 끝까지 선택하는 시도
        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i; // 선택한 수 저장
            dice3(cnt+1, i);
        }
    }

    // 조합
    private static void dice4(int cnt, int start) {
        if (cnt == N) {
            System.out.println(Arrays.toString(numbers));
            return;
        }

        // 시작점부터 가능한 끝까지 선택하는 시도
        for (int i = start; i <= 6; i++) {
            numbers[cnt] = i; // 선택한 수 저장
            dice4(cnt+1, i+1);
        }
    }
}
