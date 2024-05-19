
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			TreeMap<Long, Integer> tm = new TreeMap<>();
			for(int j=0;j<num;j++) {
				String[] tmp = br.readLine().split(" ");
				String sign = tmp[0];
				long number = Long.parseLong(tmp[1]);
				if(sign.equals("I")) {
					tm.put(number, tm.getOrDefault(number, 0)+1);
				}
				else if(sign.equals("D")){
					if(number==1 && !tm.isEmpty()) {
						// 최대값
						long maxKey = tm.lastKey();
						if(tm.get(maxKey)>1) {
							tm.put(maxKey, tm.get(maxKey)-1);
						} else tm.remove(maxKey);
					}
					else if(number==-1 && !tm.isEmpty()){
						// 최소값

//						for(Integer item: tm.keySet()) {
//							System.out.println(item);
//						}
						long minKey = tm.firstKey();
						if(tm.get(minKey)>1) {
							tm.put(minKey, tm.get(minKey)-1);
						} else tm.remove(minKey);
					}
				}
				
			}
//			System.out.println(tm.size());
//			for(Integer item: tm.keySet()) {
//				System.out.println(tm.get(item));
//			}
			if(tm.isEmpty()) {
				System.out.println("EMPTY");

			}
			else System.out.println(tm.lastKey()+" "+tm.firstKey());
		}
	}
}
