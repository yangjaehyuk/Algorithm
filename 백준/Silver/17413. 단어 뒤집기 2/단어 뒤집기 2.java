
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str+=' ';
		int idx = str.indexOf('<');
		StringBuilder sb = new StringBuilder();
		String res = null;
		if(idx == -1) {
			// < 없는 경우
			String[] ans = str.split(" ");
			for(String item: ans) {
				for(int j=item.length()-1;j>=0;j--) {
					sb.append(item.charAt(j));
				}
				sb.append(' ');
			}
			res = sb.toString().substring(0,sb.toString().length()-1);
			
		}
		else {
			// < 있는 경우
			boolean check = false;
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) == '<') {
					while(!stack.empty()) {
						sb.append(stack.pop());
					}
					sb.append(str.charAt(i));
					check = true;
				}
				else if(str.charAt(i) == '>') {
					sb.append(str.charAt(i));
					check = false;
				}
				else if(check == false) {
					if(str.charAt(i) == ' ') {
						while(!stack.isEmpty()) {
							sb.append(stack.pop());
						}
						sb.append(' ');
					}
					else {
						stack.add(str.charAt(i));
					}
				}
				else if(check == true) {
					sb.append(str.charAt(i));
				}
				
			}
			res = sb.toString();
			if(res.charAt(res.length()-1) == ' ') res = res.substring(0, res.length()-1);
			
		}
		System.out.print(res);
	}

}
