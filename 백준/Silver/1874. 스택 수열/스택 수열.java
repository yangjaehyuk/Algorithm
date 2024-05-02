
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			list.add(tmp);
		}
		int num = 1;
		int idx = 0;
		int cnt = 1;
		boolean flag = true;
		for(int i=0;i<n;i++) {
			while(cnt<=list.get(idx)) {
				stack.add(cnt);
				sb.append("+").append("\n");
				cnt++;
			}
			if(stack.peek().equals(list.get(idx))) {
				stack.pop();
				sb.append("-").append("\n");
				idx++;
			}
			else flag = false;
		}
		if(flag) System.out.print(sb.toString());
		else System.out.print("NO");
		
	}
	

}