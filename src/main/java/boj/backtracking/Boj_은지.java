package boj.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_은지 {
    static int N,M;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N =Integer.parseInt(st.nextToken());
        M =Integer.parseInt(st.nextToken());

        num =new int[N];
        StringTokenizer st1 =new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] =Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(num); // 1 7 8 9

        for (int i = 0; i < N; i++) {

            int[] visited =new int[N];
            int[] arr =new int[N];
            arr[0] = num[i];
            visited[i] = 1;
            fun(arr,visited,1);
        }


    }

    static void fun(int[] arr, int[] visited, int indx){
        if(indx == M){
            for(int i=0; i<M; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]!=1){
                arr[indx] =num[i];
                visited[i] =1;
                fun(arr,visited,indx+1);
                //visited[i] = 0;
            }
        }
    }
}