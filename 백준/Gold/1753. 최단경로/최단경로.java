
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;


public class Main {
	static int INF = 987654321;
	static int dis[];
	static List<Node>[] graph;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int node = Integer.parseInt(docs[0]);
		int line = Integer.parseInt(docs[1]);
		int s = Integer.parseInt(br.readLine());
		dis = new int[node+1];
		for(int i=0;i<node+1;i++) {
			dis[i] = INF;
		}
		dis[s] = 0;
		graph = new ArrayList[node+1];
		for(int i=0;i<node+1;i++) {
			graph[i] = new ArrayList<Node>();
		}
		for(int i=0;i<line;i++) {
			String[] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			int wei = Integer.parseInt(tmp[2]);
			graph[start].add(new Node(end, wei));
		}
		
		djstra(s);
		for(int i=1;i<node+1;i++) {
			if(dis[i]==INF) System.out.println("INF");
			else System.out.println(dis[i]);
		}
	}
	
	public static void djstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>((x,y) -> x.weight - y.weight);
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node no = pq.poll();
			
			if(dis[no.to]<no.weight) {
				continue;
			}
			
			for(int i=0;i<graph[no.to].size();i++) {
				Node tmp = graph[no.to].get(i);
				int nxt = tmp.to;
				int nxtwei = tmp.weight;
				
				if(dis[nxt]>dis[no.to]+nxtwei) {
					dis[nxt] = dis[no.to]+nxtwei;
					pq.add(new Node(nxt, dis[nxt]));
				}
			}
		}
	}
	
	public static class Node{
		int to;
		int weight;
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
}
