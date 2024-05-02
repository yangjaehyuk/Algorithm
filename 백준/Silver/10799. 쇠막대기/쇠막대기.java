
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		int ans = 0;
		for(int i=0;i<doc.length();i++) {
			if(doc.charAt(i) == '(') {
				stack.add('(');
				continue;
			}
			else {
				stack.pop();
				if(doc.charAt(i-1) == '(') ans+=stack.size();
				else ans++;
			}
		}
		System.out.println(ans);
	}

}
