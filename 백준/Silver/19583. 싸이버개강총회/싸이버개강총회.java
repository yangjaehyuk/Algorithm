
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] times = br.readLine().split(" ");
		String[] start = times[0].split(":");
		String[] chatting = times[1].split(":");
		String[] end = times[2].split(":");
		int startInt = 60*Integer.parseInt(start[0]) + Integer.parseInt(start[1]);
		int chattingInt = 60*Integer.parseInt(chatting[0]) + Integer.parseInt(chatting[1]);
		int endInt = 60*Integer.parseInt(end[0]) + Integer.parseInt(end[1]);
		Map<String, Integer> map = new HashMap<String, Integer>();
		while(true) {
			try {
				String[] time = br.readLine().split(" ");
				String[] inTime = time[0].split(":");
				
				String name = time[1];
				int timeInt = 60*Integer.parseInt(inTime[0])+Integer.parseInt(inTime[1]);
				if(timeInt<=startInt && !map.containsKey(name)) {
					map.put(name, 1);
				}
				else if(map.containsKey(name)) {
					if(timeInt>=chattingInt && timeInt<=endInt) {
						map.put(name, 0);
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				break;
			}
			
			
		}
		for(String item: map.keySet()) {
			if(map.get(item)==0) cnt++;
		}
		System.out.println(cnt);
	}
}
