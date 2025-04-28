import java.util.*;

class Solution {
    
    static class FileStr implements Comparable<FileStr> {
        String str;
        int index;
        
        public FileStr(String str, int index) {
            this.str = str;
            this.index = index;
        }
        
        @Override
        public int compareTo(FileStr o) {
            
            String thisHead = "";
            String oHead = "";
            
            String thisNum = "";
            String oNum = "";
            
            // this.str 숫자 추출
boolean headFlag = false;
int idx = 0;
for (int i = 0; i < this.str.length(); i++) {
    if (!headFlag && Character.isDigit(this.str.charAt(i))) {
        thisHead = this.str.substring(0, i);
        idx = i;
        headFlag = true;
    }
    if (headFlag && (i == this.str.length() - 1 || !Character.isDigit(this.str.charAt(i)))) {
        thisNum = this.str.substring(idx, (Character.isDigit(this.str.charAt(i)) ? i + 1 : i));
        break;
    }
}

// o.str 숫자 추출
headFlag = false;
idx = 0;
for (int i = 0; i < o.str.length(); i++) {
    if (!headFlag && Character.isDigit(o.str.charAt(i))) {
        oHead = o.str.substring(0, i);
        idx = i;
        headFlag = true;
    }
    if (headFlag && (i == o.str.length() - 1 || !Character.isDigit(o.str.charAt(i)))) {
        oNum = o.str.substring(idx, (Character.isDigit(o.str.charAt(i)) ? i + 1 : i));
        break;
    }
}

            
            
            if (!thisHead.toUpperCase().equals(oHead.toUpperCase())) {
                return thisHead.toUpperCase().compareTo(oHead.toUpperCase());
            } else {
                if (Integer.parseInt(thisNum) != Integer.parseInt(oNum)) {
                    return Integer.parseInt(thisNum) - Integer.parseInt(oNum);    
                } else {
                    return this.index - o.index;
                }
                
            }
            
        }
    }
    
    public String[] solution(String[] files) {
        
        List<FileStr> list = new ArrayList<>();
        
        for (int i = 0; i < files.length; i++) {
            list.add(new FileStr(files[i], i));
        }

        Collections.sort(list);
        
        String[] result = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).str;
        }
        
        return result;
        
    }
}