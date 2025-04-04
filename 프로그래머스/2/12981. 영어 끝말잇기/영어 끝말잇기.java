/*
배열의 길이는 100이하. 반복문으로 해결가능
몇번 사람인지, 자신의 몇번째 차례인지
*/
import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        String prev = words[0];
        List<String> useWords = new ArrayList<>();
        useWords.add(prev);
        
        int people = 0;
        int num = 0;
        
        boolean flag = false;
        for (int i = 1; i < words.length; i++) {
            if (prev.charAt(prev.length()-1) == words[i].charAt(0)) { // 끝말잇기 되는지
                for (int j = 0; j < useWords.size(); j++) {
                    if (useWords.get(j).equals(words[i])) {
                        flag = true;
                        break;
                    }
                }
                
                if (flag) {
                    // 실패 i+1 = 5
                    if ((i+1) % n == 0) {
                        people = n;
                        num = (i+1)/n;
                    } else {
                        people = (i+1) % n;
                        num = ((i+1) / n) + 1;
                    }
                
                    break;
                    
                } else {
                    // 성공
                    useWords.add(words[i]);
                    prev = words[i];
                    continue;
                }
                
            } else {
                // 실패
                flag = true;
                if ((i+1) % n == 0) {
                        people = n;
                        num = (i+1)/n;
                    } else {
                        people = (i+1) % n;
                        num = ((i+1) / n) + 1;
                    }
                    
                break;
            }
        }
        
        int[] answer = new int[2];
        if (flag) {
            answer[0] = people;
            answer[1] = num;    
        }
        

        return answer;
    }
}