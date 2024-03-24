

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    static boolean[] visited2;

    static int[][] grid;

    static boolean[] visited;

    static int[] people;

    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        grid = new int[N + 1][N + 1];

        visited2 = new boolean[N+1]; // 부분집합에 사용

        visited = new boolean[N + 1]; // bfs에 사용

        people = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                grid[i][Integer.parseInt(st.nextToken())] = 1;
            }
        }


        result = Integer.MAX_VALUE;

        makePowerSet(1);

        if (result != Integer.MAX_VALUE) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }


    public static void makePowerSet(int depth) {
        if (depth == N+1) {
            List<Integer> list = new ArrayList<>();
            List<Integer> nList = new ArrayList<>();
            for (int i = 1; i <= N; i++) {
                if (visited2[i]) {
                    list.add(i);
                } else {
                    nList.add(i);
                }
            }


            if (list.size() != 0 && list.size() != N) {
                // list의 값이 연결되었는지와 list에 속하지 않은 값이 연결되었는지 확인
                visited = new boolean[N + 1];
                if ((inList(list.get(0), list)) && inList(nList.get(0), nList)) {
                    int sectionACnt = 0;
                    int sectionBCnt = 0;
                    for (int k = 0; k < list.size(); k++) {
                        sectionACnt += people[list.get(k)];
                    }

                    for (int k = 0; k < nList.size(); k++) {
                        sectionBCnt += people[nList.get(k)];
                    }

                    if (Math.abs(sectionACnt - sectionBCnt) < result) {
                        result = Math.abs(sectionACnt - sectionBCnt);

                    }

                }

            }
            return;
        }

        visited2[depth] = true;
        makePowerSet(depth+1);
        visited2[depth] = false;
        makePowerSet(depth+1);
    }

    public static boolean inList(int start, List<Integer> Alist) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        visited[start] = true;

        queue.add(start);

        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            for (int i = 1; i <= N; i++) {
                if (grid[now][i] == 1 && !visited[i]) {
                    boolean flag = false;
                    for (int k = 0; k < Alist.size(); k++) {
                        if (Alist.get(k) == i) {
                            flag = true;
                            break;
                        }
                    }
                    if (flag) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }

        }

        boolean flag = true;

        for (int i = 0; i < Alist.size(); i++) {
            if (!visited[Alist.get(i)]) {
                flag = false;
            }
        }

        return flag;
    }

}
