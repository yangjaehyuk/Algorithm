

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<Integer>();
		int sum = 0;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) stack.pop();
			else stack.add(num);
		}
		for(Integer item: stack) {
			sum += item;
		}
		System.out.println(sum);
	}
}
