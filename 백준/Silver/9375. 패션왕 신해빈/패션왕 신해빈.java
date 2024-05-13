
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			Map<String, Integer> map = new HashMap<String, Integer>();
			int cases = Integer.parseInt(br.readLine());
			for(int j=0;j<cases;j++) {
				String[] tmp = br.readLine().split(" ");
				if(map.containsKey(tmp[1])) {
					int val = map.get(tmp[1]);
//					System.out.println(val);
					map.put(tmp[1], val+=1);
				}
				else map.put(tmp[1], 1);
			}
			if(map.size()==1) {
				List<String> list = new ArrayList<String>(map.keySet());
				System.out.println(map.get(list.get(0)));
			}
			else {
				int res = 1;
				for(String item: map.keySet()) {
					int tmp = 0;
					tmp+=map.get(item)+1;
					res*=tmp;
				}
				System.out.println(--res);
			}
		}
	}

}
