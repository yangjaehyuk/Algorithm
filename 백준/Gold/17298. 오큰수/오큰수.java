
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		Stack<Integer> s = new Stack<Integer>();
		int[] ans = new int[n];
		StringBuilder sb = new StringBuilder();
		for(int i=n-1;i>=0;i--) {
			while(!s.isEmpty() && s.peek() <= Integer.parseInt(arr[i])) {
//				
				s.pop();
			}
			if(s.isEmpty()) {
				ans[i] = -1;
			}
			else {
				ans[i] = s.peek();
//				System.out.print(s.peek()+" ");
			}
			s.push(Integer.parseInt(arr[i]));
		}
		for(int i: ans) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString().trim());
	}
	
	

}
