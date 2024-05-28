
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		
		String from = docs[0];
		String to = docs[1];
		bfs(from, to);
	}
	
	public static void bfs(String from, String to) {
		Map<Long, Long> map = new HashMap<Long, Long>();
		long intFrom = Long.parseLong(from);
		long intTo = Long.parseLong(to);
		Queue<String> q = new LinkedList<String>();
		
		q.add(from);
		map.put(intFrom, (long) 1);
		while(!q.isEmpty()) {
			String now = q.poll();
			long intNow = Long.parseLong(now);
			if(intNow == intTo) {
				System.out.println(map.get(intTo));
				return;
			}
			// 2배 곱하기
			String twice = Long.toString(Long.parseLong(now)*2);
			
			if(Long.parseLong(twice) >= 0 && Long.parseLong(twice) <= Long.parseLong(to)) {
				q.add(twice);
				map.put(Long.parseLong(twice), map.get(Long.parseLong(now))+1);
			}
			// 뒤에 1 붙히기
			String plusOne = now+'1';
			if(Long.parseLong(plusOne) >= 0 && Long.parseLong(plusOne) <= Long.parseLong(to)) {
				q.add(plusOne);
				map.put(Long.parseLong(plusOne), map.get(Long.parseLong(now))+1);
			}
		}
		System.out.println(-1);
	}
}
