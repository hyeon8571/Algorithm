import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
                
        for (int i = 1; i <= N; i++) {
            list.add(i);
            list2.add(Integer.parseInt(br.readLine()));
        }
    
        while (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                int val = list.get(i);
                boolean flag = false;
                for (int j = 0; j < list2.size(); j++) {
                    if (list2.get(j) == val) {
                        flag = true;
                    }
                }
                
                if (!flag) {
                    list.remove(i);
                    list2.remove(i);
                } else {
                    HashSet<Integer> set1 = new HashSet<>();
                    HashSet<Integer> set2 = new HashSet<>();
                    
                    for (int k = 0; k < list.size(); k++) {
                        set1.add(list.get(k));
                    }
                    
                    for (int l = 0; l < list2.size(); l++) {
                        set2.add(list2.get(l));
                    }
                    
                    if (set1.size() == set2.size()) {
                        System.out.println(set1.size());
                        for (int y = 0; y < list.size(); y++) {
                            System.out.println(list.get(y));
                        }
                        
                        return;
                    }
                }
            }
        }
    
    }
}
