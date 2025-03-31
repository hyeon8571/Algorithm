import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        
        String[] strArr = s.split(" ");
        
        int[] arr = new int[strArr.length];
        
        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        
        Arrays.sort(arr);
        
        String answer = arr[0] + " " + arr[strArr.length-1];
        return answer;
    }
}