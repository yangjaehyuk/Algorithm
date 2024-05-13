
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int k = Integer.parseInt(tmp[0]);
		int l = Integer.parseInt(tmp[1]);
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<l;i++) {
			String doc = br.readLine();
			if(map.containsKey(doc)) {
				map.put(doc, i);
			}
			else map.put(doc, i);
		}
//		for(String item: map.keySet()) {
//			System.out.println(item+" "+map.get(item));
//		}
		List<String> keys = new ArrayList<String>(map.keySet());
		keys.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return map.get(o1) - map.get(o2);
			}
		});
		
		if(k>keys.size()) {
			for(int i=0;i<keys.size();i++) {
				System.out.println(keys.get(i));
			}
		}
		else {
			for(int i=0;i<k;i++) {
				System.out.println(keys.get(i));
			}
		}
		
		
		
	}
}
