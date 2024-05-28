
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int[] dx = {1,-1,2};
	public static int[] arr;
	public static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int from = Integer.parseInt(tmp[0]);
		int to = Integer.parseInt(tmp[1]);
		arr = new int[200001];
		visited = new boolean[200001];
		bfs(from, to);
		System.out.println(arr[to]);
	}
	public static void bfs(int from, int to) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(from, 0));
		visited[from] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			int now = n.index;
			int time = n.time;
			if(now*dx[2] <= 100000 && !visited[now*dx[2]]) {
				arr[now*dx[2]] = time;
				visited[now*dx[2]] = true;
				q.add(new Node(now*dx[2], time));
			}
			if(now+dx[1] >= 0 && !visited[now+dx[1]]) {
				arr[now+dx[1]] = time+1;
				visited[now+dx[1]] = true;
				q.add(new Node(now+dx[1], time+1));
			}
			if(now+dx[0] <= 100000 && !visited[now+dx[0]]) {
				arr[now+dx[0]] = time+1;
				visited[now+dx[0]] = true;
				q.add(new Node(now+dx[0], time+1));
			}
		}
	}
	
	public static class Node{
		int index;
		int time;
		Node(int index, int time){
			this.index = index;
			this.time = time;
		}
	}
}
