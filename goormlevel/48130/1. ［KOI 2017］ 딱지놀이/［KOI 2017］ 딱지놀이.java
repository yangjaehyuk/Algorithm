import java.io.*;
import java.util.*;
class Main {
	static List<Character> ans = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			Map<Integer, Integer> map1 = new HashMap<>();
			Map<Integer, Integer> map2 = new HashMap<>();
			for(int j=1;j<5;j++){
				map1.put(j,0);
				map2.put(j,0);
			}
			String[] num1 = br.readLine().split(" ");
			int[] num1Int = new int[num1.length];
			for(int j=0;j<num1.length;j++){
				num1Int[j] = Integer.parseInt(num1[j]);
			}
			for(int j=1;j<num1.length;j++){
				if(map1.containsKey(num1Int[j])){
					int val = map1.get(num1Int[j]);
					map1.put(num1Int[j], val+1);
				}
			}
			List<Integer> list1 = new ArrayList<>(map1.keySet());
			Collections.sort(list1, Collections.reverseOrder());
			// for(Integer key1: list1){
			// 	System.out.print(key1+" "+map1.get(key1)+" ");
			// }
			// System.out.println();
			String[] num2 = br.readLine().split(" ");
			int[] num2Int = new int[num2.length];
			for(int j=0;j<num2.length;j++){
				num2Int[j] = Integer.parseInt(num2[j]);
			}
			for(int j=1;j<num2.length;j++){
				if(map2.containsKey(num2Int[j])){
					int val = map2.get(num2Int[j]);
					map2.put(num2Int[j], val+1);
				}
			}
			List<Integer> list2 = new ArrayList<>(map2.keySet());
			Collections.sort(list2, Collections.reverseOrder());
			// for(Integer key2: list2){
			// 	System.out.print(key2+" "+map2.get(key2)+" ");
			// }
			// System.out.println();
			// System.out.println(list1.size()+" "+list2.size());
			// System.out.println(map1.get(4)+" "+map2.get(4));
			boolean check = true;
			for(int j=4;j>0;j--){
				if(map1.get(j) > map2.get(j)){
					// System.out.println('A');
					ans.add('A');
					check = false;
					break;
				}
				else if(map1.get(j) < map2.get(j)){
					// System.out.println('B');
					ans.add('B');
					check = false;
					break;
				}
			}
			// if(check) System.out.println('D');
			if(check) ans.add('D');
		}
		for(Character s: ans){
			System.out.println(s);
		}
		System.out.println();
	}
}