
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		Stack<Integer> stack = new Stack<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split(" ");
			if(arr.length > 1) {
				int num = Integer.parseInt(arr[1]);
				stack.add(num);
			}
			else {
				if(arr[0].equals("pop")) {
					if(stack.size() == 0) System.out.println(-1);
					else {
						System.out.println(stack.peek());
						stack.pop();
					}
				}
				else if(arr[0].equals("size")) System.out.println(stack.size());
				else if(arr[0].equals("empty")) {
					if(stack.isEmpty()) System.out.println(1);
					else System.out.println(0);
				}
				else {
					if(stack.isEmpty()) System.out.println(-1);
					else System.out.println(stack.peek());
				}
			}
		}
	}
}
