import java.io.*;
import java.util.*;

public class Main {
    
    public static List<String> oper;
    public static int N;
    public static List<String> result;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            
            oper = new ArrayList<>();
            result = new ArrayList<>();
            dfs(1);
            
            Collections.sort(result); // 사전순 정렬

            StringBuilder sb = new StringBuilder();
            
            for (int k = 0; k < result.size(); k++) {
                sb.append(result.get(k)).append("\n");
            }
            
            System.out.print(sb);
            System.out.println();
        }
        
        
    }
    
    public static void dfs(int i) {
        
        if (i == N) {
            String str = "";
            for (int k = 1; k <= N; k++) {
                str += k;
                
                if (k == N) {
                    break;
                }
                
                str += oper.get(k-1);
            }
            
            String expr = str.replaceAll(" ", ""); // 공백 제거
            if (evaluate(expr) == 0) {
                result.add(str); // 원래 수식 형태 저장
            }
            return;
        }
        
        
        // + - 공백
        
        oper.add("+");
        dfs(i+1);
        oper.remove(oper.size() - 1);
        
        oper.add("-");
        dfs(i+1);
        oper.remove(oper.size() - 1);
        
        oper.add(" ");
        dfs(i+1);
        oper.remove(oper.size() - 1);
    }
    
    public static int evaluate(String expr) {
    List<Integer> nums = new ArrayList<>();
    List<Character> ops = new ArrayList<>();

    int idx = 0;
    while (idx < expr.length()) {
        int j = idx;
        while (j < expr.length() && Character.isDigit(expr.charAt(j))) {
            j++;
        }
        int number = Integer.parseInt(expr.substring(idx, j));
        nums.add(number);

        if (j < expr.length()) {
            ops.add(expr.charAt(j));
        }

        idx = j + 1;
    }

    int sum = nums.get(0);
    for (int i = 0; i < ops.size(); i++) {
        if (ops.get(i) == '+') sum += nums.get(i + 1);
        else sum -= nums.get(i + 1);
    }

    return sum;
}
}
