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
		arr = new int[m][n];
		visited = new boolean[m][n];
		for(int i=0;i<m;i++){
		    String[] tmp = br.readLine().split(" ");
		    for(int j=0;j<tmp.length;j++){
		        arr[i][j] = Integer.parseInt(tmp[j]);
		    }
		}
		boolean flag = true;
		for(int i=0;i<m;i++){
		    for(int j=0;j<n;j++){
		        if(arr[i][j] == 0){
		            flag = false;
		            break;
		        }
		    }
		}
		if(flag){
		    System.out.println(0);
		    return;
		}
		Queue<Pair> q = new LinkedList<>();
		for(int i=0;i<m;i++){
		    for(int j=0;j<n;j++){
		        if(arr[i][j] == 1){
		            q.add(new Pair(i, j));
		            visited[i][j] = true;
		        }
		    }
		}
		
		while(!q.isEmpty()){
		    Pair p = q.poll();
		    int x = p.x;
		    int y = p.y;
		    for(int i=0;i<4;i++){
		        int nx = x + dx[i];
		        int ny = y + dy[i];
		        if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && arr[nx][ny] == 0){
		            q.add(new Pair(nx, ny));
		            visited[nx][ny] = true;
		            arr[nx][ny] = arr[x][y] + 1;
		        }
		    }
		}
		int maxi = 0;
		for(int i=0;i<m;i++){
		    for(int j=0;j<n;j++){
		        maxi = Math.max(maxi, arr[i][j]);
		        if(arr[i][j] == 0) {
		            System.out.println(-1);
		            return;
		        }
		    }
		}
		
		System.out.println(maxi - 1);
		
		
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