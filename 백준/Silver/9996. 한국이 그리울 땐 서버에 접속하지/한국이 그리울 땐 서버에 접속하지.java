import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String pattern = sc.next();
		int starIdx = pattern.indexOf('*');
		String first = pattern.substring(0, starIdx);
		String last = pattern.substring(starIdx+1);
		
		for(int i=0;i<n;i++) {
			String tmp = sc.next();
			if(tmp.length() < first.length() + last.length()) {
				System.out.println("NE");
				continue;
			}
			String front = tmp.substring(0, first.length());
			String back = tmp.substring(tmp.length() - last.length());
			if(front.equals(first) && back.equals(last)) System.out.println("DA");
			else System.out.println("NE");
		}
	}

}
