
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		int n=sc.nextInt();
		int m=sc.nextInt();
		int ans = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String hamming = sc.next();
			list.add(hamming);
		}
		for(int i=0;i<m;i++) {
			Map<Character, Integer> map = new HashMap<>();
			List<Integer> tmp = new ArrayList<Integer>();
			List<Character> alpha = new ArrayList<Character>();
			for(int j=0;j<list.size();j++) {
				map.put(list.get(j).charAt(i), map.getOrDefault(list.get(j).charAt(i), 0)+1);
				
			}
			for(Character key: map.keySet()) {
				tmp.add(map.get(key));
			}
			Collections.sort(tmp, Collections.reverseOrder());
			int maxi = tmp.get(0);
			ans += n-maxi;
			for(Character key: map.keySet()) {
				if(map.get(key) == maxi) {
					alpha.add(key);
				}
			}
			Collections.sort(alpha);
			sb.append(alpha.get(0));
		}
		System.out.println(sb.toString());
		System.out.println(ans);
		
	}

}
