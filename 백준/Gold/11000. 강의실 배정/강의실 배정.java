
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		List<Pair> list = new ArrayList<Pair>();
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
				if(p1.x == p2.x) return p1.y - p2.y;
				else return p1.x - p2.x;
			}
		});
//		for(Pair p: list) {
//			System.out.println(p.x+" "+p.y);
//		}
		pq.offer(list.get(0).y);
		for(int i=1;i<n;i++) {
			if(pq.peek()<=list.get(i).x) {
				pq.poll();
			}
			
			pq.offer(list.get(i).y);
		}
		System.out.println(pq.size());
		
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
