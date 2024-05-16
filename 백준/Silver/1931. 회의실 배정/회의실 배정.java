
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<Pair>();
		int cnt = 0;
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			int s = Integer.parseInt(tmp[0]);
			int e = Integer.parseInt(tmp[1]);
			Pair p = new Pair(s,e);
			list.add(p);
		}
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				// TODO Auto-generated method stub
				if(p1.end==p2.end) return p1.start-p2.start;
				return p1.end - p2.end;
			}
		});
		List<Pair> ans = new ArrayList<Pair>();
//		for(Pair p: list) {
//			System.out.println(p.start+" "+p.end);
//		}
		for(int i=0;i<list.size();i++) {
			if(i==0) {
				ans.add(new Pair(list.get(i).start, list.get(i).end));
				cnt++;
			}
			else {
				if(ans.get(ans.size()-1).end<=list.get(i).start) {
					ans.add(new Pair(list.get(i).start, list.get(i).end));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
	public static class Pair{
		int start;
		int end;
		Pair(int start, int end){
			this.start = start;
			this.end = end;
		}
	}
}
