// 30C5 -> 완탐 가능할듯?

class Solution {
    
    static int[] selected;
    static int result = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        
        selected = new int[5];
        
        comb(0, 1, n, q, ans);
        return result;
    }
    
    public void comb(int depth, int start, int n, int[][] q, int[] ans) {
        if (depth == 5) {  
            
            
            for (int i = 0; i < q.length; i++) {
                int count = 0;
                for (int j = 0; j < q[0].length; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (q[i][j] == selected[k]) {
                            count++;
                        }
                    }
                }
                
                if (ans[i] != count) {
                    return;
                }
                
            }
            
            result++;
            
            return;
        }
        
        for (int i = start; i <= n; i++) {
            selected[depth] = i;
            comb(depth+1, i+1, n, q, ans);
        }
    }
}