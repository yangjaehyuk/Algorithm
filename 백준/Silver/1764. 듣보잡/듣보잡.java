
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n,m;
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		
		Map<String, Integer> list = new HashMap<String, Integer>();
		List<String> ans = new ArrayList<String>();
		for(int i=0;i<n;i++) {
			String person = br.readLine();
			list.put(person, 1);
		}
		for(int j=0;j<m;j++) {
			String target = br.readLine();
//			System.out.println(list.containsKey(target));
			if(list.containsKey(target) == true) {
				ans.add(target);
			}
		}
		System.out.println(ans.size());
		Collections.sort(ans);
		for(String item: ans) {
			System.out.println(item);
		}
	}

}
