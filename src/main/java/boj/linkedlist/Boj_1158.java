package boj.linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

public class Boj_1158 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int index = 0;

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.offer(i);
        }

        System.out.print("<");

        while (!list.isEmpty()) {
            index = (index + (k - 1))% list.size();
            if (list.size() != 1) {
                System.out.print(list.remove(index) + ", ");
            } else {
                System.out.print(list.remove(index));
            }
        }
        System.out.print(">");
    }
}
