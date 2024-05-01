
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] doc = br.readLine().split(" ");
		int n = Integer.parseInt(doc[0]);
		String[] how = br.readLine().split(" ");
		Map<Integer, Pair> map = new HashMap<>();
		for(int i=0;i<how.length;i++) {
			int k = Integer.parseInt(how[i]);
			if(map.containsKey(k)) {
				int val = map.get(k).val;
				val+=1;
				int firstIdx = map.get(k).idx;
				if(firstIdx != i) map.put(k, new Pair(val, firstIdx));
				else map.put(k, new Pair(val,i));
			}
			else {
				map.put(k, new Pair(1, i));
			}
		}
		List<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {

		    @Override
		    public int compare(Integer o1, Integer o2) {
		        if(map.get(o1).val != map.get(o2).val) {
		        	return -Integer.compare(map.get(o1).val, map.get(o2).val);
		        }
		        return Integer.compare(map.get(o1).idx, map.get(o2).idx);
		    }
		});

		for(Integer item: list) {
//			System.out.println(map.get(item).val);
			for(int i=0;i<map.get(item).val;i++) {
				System.out.print(item+" ");
			}
		}
	}
	public static class Pair{
		int val;
		int idx;
		Pair(int val, int idx){
			this.val = val;
			this.idx = idx;
		}
	}
}
