
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		Set<Integer> set = new HashSet<>();
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			set.add(Integer.parseInt(arr[i]));
		}
		Iterator<Integer> i = set.iterator();
		while(i.hasNext()) {
//			System.out.println(i.next());
			list.add(i.next());
		}
		Collections.sort(list);
		for(Integer item: list) {
			System.out.print(item+" ");
		}
	}

}
