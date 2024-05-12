
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		HashMap<String, List<String>> map1 = new HashMap<String, List<String>>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		for(int i=0;i<n;i++) {
			String group = br.readLine();
			List<String> list = new ArrayList<String>();
			int num = Integer.parseInt(br.readLine());
			for(int j=0;j<num;j++) {
				String name = br.readLine();
				map2.put(name, group);
				list.add(name);
			}
			Collections.sort(list);
			map1.put(group, list);
		}
		for(int i=0;i<m;i++) {
			String name = br.readLine();
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				for(String item: map1.get(name)) {
					System.out.println(item);
				}
			}
			else {
				System.out.println(map2.get(name));
			}
		}

	}

}
