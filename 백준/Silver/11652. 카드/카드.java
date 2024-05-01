
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<>();
		for(int i=0;i<n;i++) {
			long num = Long.parseLong(br.readLine());
			if(map.containsKey(num)) {
				int val = map.get(num);
				val+=1;
				map.put(num, val);
			}
			else map.put(num, 1);
		}
		List<Long> list = new ArrayList<Long>(map.keySet());
		int ans = 0;
		long mini = 0;
		for(Long key: list) {
			if(map.get(key) > ans) {
				ans = map.get(key);
				mini = key;
			}
			else if(map.get(key) == ans) {
				mini = Math.min(mini, key);
			}
		}
		System.out.println(mini);
	}
	
	
}
