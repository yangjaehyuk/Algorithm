
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int cnt = 0;
	public static int[] dx = {1,-1,2};
	public static int[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int from = Integer.parseInt(docs[0]);
		int to = Integer.parseInt(docs[1]);
		arr = new int[200001];
		bfs(from, to);
		
		if(from>=to) {
			System.out.println(from-to);
			System.out.println(1);
			return;
		}
		System.out.println(arr[to]);
		System.out.println(cnt);
	}
	
	public static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			int first = now+dx[0];
			int second = now+dx[1];
			int third = now*dx[2];
			
			if(now == end) {
				cnt++;
			}
			
			if(first<=100000 && (arr[first] == 0 || arr[first] == arr[now] + 1)) {
				arr[first] = arr[now] + 1;
				q.add(first);
			}
			
			if(second>=0 && (arr[second] == 0 || arr[second] == arr[now] + 1)) {
				arr[second] = arr[now] + 1;
				q.add(second);
			}
			
			if(third<=100000 && (arr[third] == 0 || arr[third] == arr[now] + 1)) {
				arr[third] = arr[now] + 1;
				q.add(third);
			}
		}
	}
	
	
	
}
