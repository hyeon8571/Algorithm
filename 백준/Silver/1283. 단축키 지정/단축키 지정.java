import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Character> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            Character upper = Character.toUpperCase(str.charAt(0));

            if (list.contains(upper)) {
                boolean flag = false;
                for (int j = 0; j < str.length()-1; j++) {
                    if (str.charAt(j) == ' ') {
                        Character upper1 = Character.toUpperCase(str.charAt(j+1));

                        if (!list.contains(upper1)) { // j+1번쩨가 []

                            if (j+1 != str.length()-1) {
                                list.add(upper1);
                                flag = true;
                                System.out.println(str.substring(0, j+1) + "[" + str.charAt(j+1) + "]" + str.substring(j+2));
                                break;
                            } else {
                                list.add(upper1);
                                flag = true;
                                System.out.println(str.substring(0, j+1) + "[" + str.charAt(j+1) + "]");
                            }

                        }
                    }
                }

                if (flag) {
                    continue;
                }

                boolean flag2 = false;

                    for (int k = 0; k < str.length(); k++) {
                        if (str.charAt(k) != ' ') {
                            Character upper1 = Character.toUpperCase(str.charAt(k));
                            if (!list.contains(upper1)) {

                                if (k != str.length()-1) {
                                    list.add(upper1);
                                    flag2 = true;
                                    System.out.println(str.substring(0, k) + "[" + str.charAt(k) + "]" + str.substring(k+1));
                                    break;
                                } else {
                                    list.add(upper1);
                                    flag2 = true;
                                    System.out.println(str.substring(0, k) + "[" + str.charAt(k) + "]");
                                }

                            }
                        }
                    }

                if (!flag2) {
                    System.out.println(str);
                }

            } else {
                list.add(upper);
                System.out.println("[" + str.charAt(0) + "]" + str.substring(1));
            }
        }
    }

}