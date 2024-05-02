
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			boolean check = true;
			Stack<Character> stack = new Stack<Character>();
			String doc = br.readLine();
			if(doc.charAt(0) == ')') {
				check = false;
				
			}
			for(int j=0;j<doc.length();j++) {
				// 괄호 검사
				stack.add(doc.charAt(j));
				if(stack.size()>1) {
					if(stack.get(stack.size()-1).equals(')') && stack.get(stack.size()-2).equals('(')) {
						stack.pop();
						stack.pop();
					}
				}
				
			}
//			for(Character item: stack) {
//				System.out.print(item+" ");
//			}
//			System.out.println();
			if(stack.isEmpty()) System.out.println("YES");
			else if(check == false || !stack.isEmpty())System.out.println("NO");
		}
	}
}
