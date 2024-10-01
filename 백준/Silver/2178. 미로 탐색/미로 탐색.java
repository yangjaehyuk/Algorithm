/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main
{
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] docs = br.readLine().split(" ");
		int n = Integer.parseInt(docs[0]);
		int m = Integer.parseInt(docs[1]);
		arr = new int[n][m];
		visited = new boolean[n][m];
		for(int i=0;i<n;i++){
		    String tmp = br.readLine();
		    for(int j=0;j<tmp.length();j++){
		        arr[i][j] = tmp.charAt(j)-'0';
		    }
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0, 0));
		visited[0][0] = true;
		while(!q.isEmpty()){
		    Pair p = q.poll();
		    int x = p.x;
		    int y = p.y;
		    for(int i=0;i<4;i++){
		        int nx = x + dx[i];
		        int ny = y + dy[i];
		        if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && arr[nx][ny] == 1){
		            q.add(new Pair(nx, ny));
		            visited[nx][ny] = true;
		            arr[nx][ny] = arr[x][y] + 1;
		        }
		    }
		}
		
		System.out.println(arr[n-1][m-1]);
        
// 		for(int i=0;i<n;i++){
// 		    for(int j=0;j<m;j++){
// 		        System.out.print(arr[i][j]+" ");
// 		    }
// 		    System.out.println();
// 		}
		
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