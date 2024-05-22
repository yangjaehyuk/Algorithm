
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static int[] arr;
	public static boolean[] visited;
	public static int cnt = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		
		int f = Integer.parseInt(docs[0]);
		int s = Integer.parseInt(docs[1]);
		int g = Integer.parseInt(docs[2]);
		int u = Integer.parseInt(docs[3]);
		int d = Integer.parseInt(docs[4]);
		arr = new int[f+1];
		visited = new boolean[f+1];
		for(int i=0;i<=f;i++) {
			arr[i] = 0;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		visited[s] = true;
		while(!q.isEmpty()) {
			int now = q.poll();
			int up = now+u;
			if(up>0 && up<=f && !visited[up]) {
				
				
					arr[up] = arr[now]+1;
					visited[up] = true;
					q.add(up);
				
			}
			int down = now-d;
			if(down>0 && down<=f && !visited[down]) {

				

					arr[down] = arr[now]+1;
					visited[down] = true;
					q.add(down);
				
			}
				
		}
		if(s==g) {
			System.out.println(0);
			System.exit(0);
		}
		if(arr[g]==0) {
			System.out.println("use the stairs");
		}
		else System.out.println(arr[g]);
//		for(int i=0;i<=f;i++) {
//			System.out.println(i+" "+arr[i]);
//		}
	}
}
