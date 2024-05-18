
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<Pair>();
		List<Pair> ans = new ArrayList<Pair>();
		int line = 0;
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			list.add(new Pair(x,y));
		}
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				// TODO Auto-generated method stub
				return p1.x - p2.x;
			}
		});
		
//		for(Pair p: list) {
//			System.out.println(p.x+" "+p.y);
//		}
		for(Pair p:list) {
			if(ans.isEmpty()) {
				ans.add(new Pair(p.x,p.y));
			}
			else {
				Pair last = ans.get(ans.size() - 1);
				if (p.x <= last.y) {
                    last.y = Math.max(last.y, p.y);
                } else {
                    ans.add(new Pair(p.x, p.y));
                }
			}
		}
		
		for(Pair p: ans) {
			line+=p.y-p.x;
		}
		System.out.println(line);
	}
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	
	
}
