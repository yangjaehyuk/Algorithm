

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String doc = br.readLine();
			if(doc.length() == 1 && doc.charAt(0) == '.') break;
			Stack<Character> stack = new Stack<Character>();
			for(int i=0;i<doc.length();i++) {
				if(doc.charAt(i)=='(' || doc.charAt(i)==')') stack.add(doc.charAt(i));
				else if(doc.charAt(i)=='[' || doc.charAt(i)==']') stack.add(doc.charAt(i));
				if(stack.size()>1) {
					if(stack.get(stack.size()-2).equals('(') && stack.get(stack.size()-1).equals(')')) {
						stack.pop();
						stack.pop();
					}
					else if(stack.get(stack.size()-2).equals('[') && stack.get(stack.size()-1).equals(']')) {
						stack.pop();
						stack.pop();
					}
				}
				
		}
			if(!stack.isEmpty()) System.out.println("no");
			else System.out.println("yes");
		}
	}
}
