import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] strArr = s.split(" ");
        
        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }
        
        String answer = "";
        
        for (int i = 0; i < strArr.length; i++) {
            
            if(strArr[i].length() == 0) {
    			answer += " ";
    		} else {
                answer += strArr[i].substring(0, 1).toUpperCase();
                answer += strArr[i].substring(1, strArr[i].length()).toLowerCase();
            
                answer += " ";
            }
            
        }
   
        // 입력 받은 문자열의 맨 마지막이 " " 라면 바로 answer 반환
    	if(s.substring(s.length()-1, s.length()).equals(" ")){
    		return answer;
    	}
    	
    	// 맨 마지막 " " 제거하고 answer 반환
        return answer.substring(0, answer.length()-1);
        
    }
}