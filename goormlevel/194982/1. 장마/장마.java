import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int house = Integer.parseInt(docs[0]);
		int rain = Integer.parseInt(docs[1]);
		String[] houseArr = br.readLine().split(" ");
		// List<Integer> list = new ArrayList<>();
		int[] list = new int[houseArr.length];
		for(int i=0;i<houseArr.length;i++){
			// list.add(Integer.parseInt(houseArr[i]));
			list[i] = Integer.parseInt(houseArr[i]);
		}
		List<Pair> p = new ArrayList<>();
		for(int i=1;i<=rain;i++){
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0])-1;
			int end = Integer.parseInt(tmp[1])-1;
			p.add(new Pair(start, end));
			for(int j=start;j<=end;j++){
				// list.get(j)++;
				list[j]++;
			}
			if(i % 3 == 0){
				Set<Integer> system = new HashSet<>();
				for(Pair pa: p){
					for(int j=pa.s;j<=pa.e;j++){
						system.add(j);
					}
				}
				List<Integer> systemI = new ArrayList<>(system);
				for(Integer item: systemI){
					list[item]--;
				}
				
				p.clear();
			}
		}
		for(int i=0;i<list.length;i++){
			System.out.print(list[i]+" ");
		}
		
		
	}
	public static class Pair{
		int s;
		int e;
		Pair(int s, int e){
			this.s = s;
			this.e = e;
		}
	}
}