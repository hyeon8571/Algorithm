

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, K;
	
	static Character[] num;
	
	static ArrayDeque<Character> arr1, arr2, arr3, arr4;
	
	static Set<String> result;
	
	static List<String> list;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			K = Integer.parseInt(st.nextToken());
			
			num = new Character[N];
			
			String str = br.readLine();
			
			for (int i = 0; i < N; i++) {
				num[i] = str.charAt(i);
			}
			
			int cnt = N / 4;
			
			arr1 = new ArrayDeque<>();

			arr2 = new ArrayDeque<>();

			arr3 = new ArrayDeque<>();

			arr4 = new ArrayDeque<>();
			
			result = new HashSet<>();
			
			
			String s1 = "";
			
			for (int i = 0; i < cnt; i++) {
				arr1.add(num[i]);
				s1 += num[i];
			}
			
			result.add(s1);
			
			s1 = "";
			
			for (int i = cnt; i < 2 * cnt; i++) {
				arr2.add(num[i]);
				s1 += num[i];
			}
			
			result.add(s1);
			
			s1 = "";
			
			for (int i = cnt * 2; i < 3 * cnt; i++) {
				arr3.add(num[i]);
				s1 += num[i];
			}
			
			result.add(s1);
			
			s1 = "";
			
			for (int i = cnt * 3; i < 4 * cnt; i++) {
				arr4.add(num[i]);
				s1 += num[i];
			}
			
			result.add(s1);
			
			
			for (int i = 0; i < cnt -1; i++) {
				rotate();
			}
			
			list = new ArrayList<>(result);
			
			Collections.sort(list);

			Collections.reverse(list);


			String value = "";
			
			if (list.size() < K - 1) {
				value = list.get(list.size() - 1);
			} else {

				value = list.get(K - 1);
			}
			
			
			int dap = 0;
			
			int size = value.length();
			
			for (int i = 0; i < value.length(); i++) {
				Character val = value.charAt(i);
				
				int gap = 0;
				
				if ('0' <= val && val <= '9') {
					gap = val - '0';
				} else  if (val == 'A'){
					gap = 10;
				} else if (val == 'B') {
					gap = 11;
				} else if (val == 'C') {
					gap = 12;
				} else if (val == 'D') {
					gap = 13;
				} else if (val == 'E') {
					gap = 14;
				} else {
					gap = 15;
				}
				
				size--;
				dap += Math.pow(16, size) * gap;
			}
			
			System.out.println("#" + t + " " + dap);
		}
	}
	
	public static void rotate() {
		arr2.addFirst(arr1.pollLast());
		arr3.addFirst(arr2.pollLast());
		arr4.addFirst(arr3.pollLast());
		arr1.addFirst(arr4.pollLast());
		
		int length = arr1.size();
		
		String s = "";
		
		for (int i = 0; i < length; i++) {
			Character c = arr1.pollFirst();
			arr1.addLast(c);
			s += c;
		}
		
		result.add(s);
		
		s = "";
		
		for (int i = 0; i < length; i++) {
			Character c = arr2.pollFirst();
			arr2.addLast(c);
			s += c;
		}
		
		result.add(s);
		
		s = "";
		
		for (int i = 0; i < length; i++) {
			Character c = arr3.pollFirst();
			arr3.addLast(c);
			s += c;
		}
		
		result.add(s);
		
		s = "";
		
		for (int i = 0; i < length; i++) {
			Character c = arr4.pollFirst();
			arr4.addLast(c);
			s += c;
		}
		
		result.add(s);
		
		s = "";
	}
	
}
