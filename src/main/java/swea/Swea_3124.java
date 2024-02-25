package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_3124 {

    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static int V;

    static Edge[] edgeList;

    static int[] parents;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());

            int E = Integer.parseInt(st.nextToken());

            edgeList = new Edge[E];

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int  weight = Integer.parseInt(st.nextToken());
                edgeList[i] = new Edge(from - 1, to - 1, weight);
            }

            Arrays.sort(edgeList);

            // make-set
            make();

            // 정렬된 간선 하나씩 꺼내어 신장트리 생성
            int weight = 0;
            int cnt = 0;
            for (Edge edge : edgeList) {
                if (!union(edge.from, edge.to)) continue;
                weight += edge.weight;
                if (++cnt == V-1) break;
            }
            System.out.println("#" + t + " " + weight);
        }
    }

    public static void make() {
        parents = new int[V]; // 자신의 부모나 루트를 저장

        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
    }

    public static int find(int a) {
        if (a == parents[a]) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }
}
