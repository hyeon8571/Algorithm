package ssafy_class;

import java.util.Arrays;

public class PerAndCom {
    static int[] num= {1,2,3};   // num={1,2,3,4}
    static int N=2;              // N=2, N=3
    static int sCount=0;

    private static void makePermutation(int toSelect,int[] selected, boolean[] visited) {
        if (toSelect == N) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            selected[toSelect] = num[i];
            makePermutation(toSelect + 1, selected, visited);
            visited[i] = false;
        }
    }
    //--------------------------------------------------------------------------------------
    private static void makeCombination(int toSelect, int[] selected, int startIdx) {

        if (toSelect == N) {
            System.out.println(Arrays.toString(selected));
            return;
        }

        for (int i = startIdx; i < num.length; i++) {
            selected[toSelect] = num[i];
            makeCombination(toSelect + 1, selected, i + 1);
        }
    }
    //--------------------------------------------------------------------------------------
    private static void powerSet(int cnt, boolean[] isSelected) {

    }
    //--------------------------------------------------------------------------------------
    public static void main(String[] args) {
//		1. num에서 N개를 뽑아서 만들 수 있는 순열을 모두 출력하시오.
        System.out.println("-----순열-----");
        makePermutation(0, new int[N], new boolean[num.length]);

//		2. num에서 N개를 뽑아서 만들 수 있는 조합을 모두 출력하시오.
        System.out.println("-----조합-----");
        makeCombination(0, new int[N], 0);

//		3. num으로 구성할 수 있는 모든 부분집합을 출력하시오.
        System.out.println("-----부분집합-----");
        powerSet(0, new boolean[N]);
        System.out.println("\n총 경우의 수: " + sCount);
    }
}