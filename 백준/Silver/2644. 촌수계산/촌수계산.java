
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static int answer;
	public static int cnt = 0;
	public static int num = 0;
	public static int front = 0;
	public static int back = 0;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	public static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		for(int i=0;i<=num;i++) {
			list.add(new ArrayList<>());
		}
		visited = new boolean[num+1];
		String[] ans = br.readLine().split(" ");
		front = Integer.parseInt(ans[0]);
		back = Integer.parseInt(ans[1]);
		int m = Integer.parseInt(br.readLine());
		for(int i=0;i<m;i++) {
			String[] temp = br.readLine().split(" ");
			int first = Integer.parseInt(temp[0]);
			int second = Integer.parseInt(temp[1]);
			list.get(first).add(second);
			list.get(second).add(first);
		}
		dfs(front, back, list, visited, 0);
		if(answer==0) System.out.println(-1);
		else System.out.println(answer);
		
	}
	
	public static void dfs(int start, int end, ArrayList<ArrayList<Integer>> list, boolean[] visited, int cnt) {
		visited[start] = true;
		if(start==end) {
			return;
		}
		for(int x: list.get(start)) {
			if(!visited[x]) {
				if(x==end) {
					answer=cnt+1;
					return;
				}
				dfs(x, end, list, visited, cnt+1);
			}
			
			
		}
	}
	
}
