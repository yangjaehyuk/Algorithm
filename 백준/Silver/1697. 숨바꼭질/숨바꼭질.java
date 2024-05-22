

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int[] dx = {1,-1,2};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int start= Integer.parseInt(docs[0]);
		int end = Integer.parseInt(docs[1]);
		int[] arr = new int[200001];
		boolean[] visited = new boolean[200001];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		visited[start] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x+dx[0]<=100000 && !visited[x+dx[0]]) {
				arr[x+dx[0]] = arr[x]+1;
				q.add(x+dx[0]);
				visited[x+dx[0]] = true;
			}
			if(x+dx[1]>=0 && !visited[x+dx[1]]) {
				arr[x+dx[1]] = arr[x]+1;
				q.add(x+dx[1]);
				visited[x+dx[1]] = true;
				
			}
			if(x*dx[2]<=100000 && !visited[x*dx[2]]) {
				arr[x*dx[2]] = arr[x]+1;
				q.add(x*dx[2]);
				visited[x*dx[2]] = true;
			}
		}
		System.out.println(arr[end]);
	}
}
