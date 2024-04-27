import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		String doc = sc.next();
		StringBuilder sb = new StringBuilder();
		String[] resource = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for(int i=0;i<doc.length();i++) {
			sb.append(doc.charAt(i));
			for(int j=0;j<resource.length;j++) {
				String tmp = sb.toString();
				if(tmp.contains(resource[j])){
					ans++;
					sb.delete(tmp.indexOf(resource[j]), resource[j].length() + tmp.indexOf(resource[j]));
					sb.append("1");
				}
			}
		}
		for(int i=0;i<sb.toString().length();i++) {
			if(sb.toString().charAt(i) != '1') ans++;
		}
		System.out.println(ans);
	}

}
