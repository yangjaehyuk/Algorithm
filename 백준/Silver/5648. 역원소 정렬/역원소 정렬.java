

import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		List<Long> list = new ArrayList<Long>();
		for(int i=0;i<n;i++) {
			String tmp = sc.next();
			StringBuilder sb = new StringBuilder();
			for(int j=tmp.length()-1;j>=0;j--) {
				sb.append(tmp.charAt(j));
			}
			long res = Long.parseLong(sb.toString());
			list.add(res);
		}
		Collections.sort(list);
		for(Long item: list) {
			System.out.println(item);
		}
	}
}
