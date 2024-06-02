
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	static int[] dis;
	static int INF = 987654321;
	static List<Pair>[] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int bus = Integer.parseInt(br.readLine());
		dis = new int[n+1];
		
		graph = new ArrayList[n+1];
		
		for(int i=0;i<n+1;i++) {
			graph[i] = new ArrayList<Pair>();
		}
		
		for(int i=0;i<bus;i++) {
			String[] docs = br.readLine().split(" ");
			int start = Integer.parseInt(docs[0]);
			int end = Integer.parseInt(docs[1]);
			int wei = Integer.parseInt(docs[2]);
			
			graph[start].add(new Pair(end, wei));
		}
		
		String[] ans = br.readLine().split(" ");
		int s = Integer.parseInt(ans[0]);
		int e = Integer.parseInt(ans[1]);
		
		for(int i=0;i<n+1;i++) {
			dis[i] = INF;
		}
		dis[s] = 0;
		djstra(s);
		
		System.out.println(dis[e]);
	}
	
	public static void djstra(int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.weight - y.weight);
		pq.add(new Pair(start, 0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			if(dis[p.to]<p.weight) continue;
			
			for(int i=0;i<graph[p.to].size();i++) {
				Pair pair = graph[p.to].get(i);
				int nxtWeight = pair.weight;
				int nxt = pair.to;
				if(dis[nxt]>dis[p.to]+nxtWeight) {
					dis[nxt] = dis[p.to]+nxtWeight;
					pq.add(new Pair(nxt, dis[nxt]));
				}
			}
		}
	}
	
	public static class Pair{
		int to;
		int weight;
		
		Pair(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
	
	
}
