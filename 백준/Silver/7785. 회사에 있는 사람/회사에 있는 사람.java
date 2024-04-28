
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> map = new HashMap<String, Integer>();
		String str = br.readLine();
		int n = Integer.parseInt(str);
		List<String> ans = new ArrayList<String>();
		for(int i=0;i<n;i++) {
			String[] info = br.readLine().split(" ");
			String name = info[0];
			String status = info[1];
			if(status.equals("enter")) {
				map.put(name, 1);
			}
			else if(status.equals("leave")) {
				map.put(name, 0);
			}
		}
		for(String key: map.keySet()) {
			if(map.get(key) == 1) {
				ans.add(key);
			}
		}
		Collections.sort(ans, Collections.reverseOrder());
		for(String item: ans) {
			System.out.println(item);
		}
	}

}
