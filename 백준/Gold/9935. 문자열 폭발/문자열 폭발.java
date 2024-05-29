
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String docs = br.readLine();
		StringBuilder sb = new StringBuilder();
		String bomb = br.readLine();
		Stack<Character> s = new Stack<Character>();
		for(int i=0;i<docs.length();i++) {
			s.add(docs.charAt(i));
			if(s.size()>=bomb.length()) {
				boolean check = false;
				for(int j=0;j<bomb.length();j++) {
					if(bomb.charAt(j) == s.get(s.size()-bomb.length()+j)) {
//						System.out.println(bomb.charAt(j)+" "+i);
						check = true;
					}
					else {
						check = false;
						break;
					}
				}
				if(check==true) {
					for(int k=0;k<bomb.length();k++) {
						s.pop();
					}
				}
			}
			
		}
//		System.out.println(s.size());
		for(Character c: s) {
			sb.append(c);
		}
		if(sb.toString().length()==0) System.out.println("FRULA");
		else System.out.println(sb.toString());
	}
}
