package ssafy_class;

public class PerAndComAndSub {

    static int N, M;

    static int[] num;

    static boolean[] visited;

    public static void main(String[] args) {

    }

    // 조합
    public static void combination(int depth, int startIdx) {
        if (depth == M) {
            return;
        }

        for (int i = startIdx; i < N; i++) {
            num[depth] = i;
            combination(depth + 1, i + 1);
        }
    }

    // 순열
    public static void permutation(int depth) {
        if (depth == M) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            num[depth] = i;
            permutation(depth + 1);
            visited[i] = false;
        }
    }


    // 부분집합
    public static void subset(int depth) {

        if (depth == N) {

            for (int i = 0; i < N; i++) {
                if (visited[i]) {
                    // 출력
                }
            }
            return;
        }

        visited[depth] = true;
        subset(depth + 1);
        visited[depth] = false;
        subset(depth + 1);

    }
}
