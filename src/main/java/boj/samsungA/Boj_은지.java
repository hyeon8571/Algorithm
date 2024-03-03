package boj.samsungA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_은지 {
    static int N;
    static int[][] city;
    static boolean[] visited;
    static int cost;
    static int k;
    static int ans;

    static void travel(int start, int cnt){
        if(cnt ==N-1){
            if(city[start][k] ==0) return;

            cost+=city[start][k];
            if(ans>cost) ans =cost;
            return;
        }

        for(int i=0; i<N; i++){
            if(i==k) continue;

            if(city[start][i]!=0 && !visited[i]) {
                visited[i] =true;
                cost+=city[start][i];
                travel(i,cnt+1);
                visited[i] =false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N =Integer.parseInt(br.readLine());
        city =new int[N][N];
        visited =new boolean[N];
        StringTokenizer st =null;

        for(int i=0; i<N; i++){
            st =new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                city[i][j] =Integer.parseInt(st.nextToken());
            }
        } //city 세팅 끝

        ans = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            k =i;
            cost =0;
            visited[i] =true;
            travel(i,0);
            visited[i] =false;
        }

        System.out.println(ans);
    }
}