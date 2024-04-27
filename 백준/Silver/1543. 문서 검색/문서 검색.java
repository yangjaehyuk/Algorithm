
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String doc = sc.nextLine();
		String search = sc.nextLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<doc.length();i++) {
			sb.append(doc.charAt(i));
		}
		int ans = 0;
		int idx = 0;
		while(true) {
			if(idx > doc.length() || idx + search.length() > doc.length()) {
				break;
			}
			String tmp = sb.toString().substring(idx, idx+search.length());
			if(tmp.equals(search)) {
				ans++;
				idx+=search.length();
			}
			else idx++;
		}
		System.out.println(ans);
	}
}
