import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());
            
            if(K == 1) {
                System.out.println("1 1");
                continue;
            }
            
            int[] alpha = new int[26];
            for (int j = 0; j < W.length(); j++) {
                alpha[W.charAt(j) - 'a']++;
            }
            
            
            int min = Integer.MAX_VALUE;
            int max = -1;
            for (int j = 0; j < W.length(); j++) {
                if(alpha[W.charAt(j) - 'a'] < K) continue;
                
                int count = 1;
                for (int l = j+1; l < W.length(); l++) {
                    if (W.charAt(j) == W.charAt(l)) count++;
                    if (count == K) {
                        min = Math.min(min, l - j + 1);
                        max = Math.max(max, l - j + 1);
                        break;
                    }
                }
            }
            if(min == Integer.MAX_VALUE || max == -1) System.out.println("-1");
            else System.out.println(min + " " + max);
        }
    }
}
