
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		int val = 1;
		int ans = 0;
		Stack<Character> s = new Stack<Character>();
		for(int i=0;i<doc.length();i++) {
			if(doc.charAt(i)=='(') {
				s.push(doc.charAt(i));
				val*=2;
			}
			else if(doc.charAt(i)=='[') {
				s.push(doc.charAt(i));
				val*=3;
			}
			else if(doc.charAt(i)==')') {
				if(s.isEmpty() || s.peek() != '(') {
					ans = 0;
					break;
				}
				else if(doc.charAt(i-1)=='(') ans+=val;
				s.pop();
				val/=2;
			}
			else if(doc.charAt(i)==']') {
				if(s.isEmpty() || s.peek() != '[') {
					ans = 0;
					break;
				}
				else if(doc.charAt(i-1)=='[') ans+=val;
				s.pop();
				val/=3;
			}
			
			
		}
		if(!s.isEmpty()) System.out.println(0);
		else System.out.println(ans);
//		System.out.println(s.size());
	}

}
