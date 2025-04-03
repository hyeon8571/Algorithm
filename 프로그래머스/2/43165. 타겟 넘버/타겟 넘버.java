class Solution {
    
    static int result = 0;
    
    public int solution(int[] numbers, int target) {
        
        boolean[] flag = new boolean[numbers.length]; // true면 -, false면 +
        
        dfs(0, numbers, flag, target);
        
        return result;
    }
    
    public static void dfs(int startX, int[] numbers, boolean[] flag, int target) {
        if (startX == flag.length) {
            
            int sum = 0;
            
            for (int i = 0; i < flag.length; i++) {
                if (!flag[i]) {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            
            if (sum == target) {
                result++;
            }
            
            return;
        }
        
        flag[startX] = true;
        dfs(startX+1, numbers, flag, target);
        flag[startX] = false;
        dfs(startX+1, numbers, flag, target);
        
    }
}