
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
	public static int from = 0;
	public static int to = 0;
	public static int[] arr;
	public static int[] dx = {1,-1,2};
	public static int[] lis;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		from = Integer.parseInt(docs[0]);
		to = Integer.parseInt(docs[1]);
		arr = new int[200001];
		lis = new int[200001];
		bfs();
		Stack<Integer> s = new Stack<Integer>();
		s.add(to);
		int idx = to;
		while(idx!=from) {
			s.add(lis[idx]);
			idx = lis[idx];
		}

		System.out.println(arr[to]);
		while(!s.isEmpty()) {
			System.out.print(s.pop()+" ");
		}
		System.out.println();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(from);
		while(!q.isEmpty()) {
			int now = q.poll();
			if(now == to) {
				return;
			}
			
			int first = now+dx[0];
			int second = now+dx[1];
			int third = now*dx[2];
			
			if(first<=100000 && (arr[first] == 0 || arr[first] == arr[now] + 1)) {
				arr[first] = arr[now] + 1;
				lis[first] = now;
				q.add(first);
			}
			
			if(second>=0 && (arr[second] == 0 || arr[second] == arr[now] + 1)) {
				arr[second] = arr[now] + 1;
				lis[second] = now;
				q.add(second);
			}
			
			if(third<=100000 && (arr[third] == 0 || arr[third] == arr[now] + 1)) {
				arr[third] = arr[now] + 1;
				lis[third] = now;
				q.add(third);
			}
			
		}
	}
}
