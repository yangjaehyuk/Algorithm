
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int i=0;i<n;i++) {
			String doc = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			for(int j=0;j<doc.length();j++) {
				stack.add(doc.charAt(j));
				if(stack.size()>1 && stack.get(stack.size()-1).equals(stack.get(stack.size()-2))) {
					stack.pop();
					stack.pop();
				}
			}
			if(stack.isEmpty()) ans++;
		}
		System.out.println(ans);
	}
}
