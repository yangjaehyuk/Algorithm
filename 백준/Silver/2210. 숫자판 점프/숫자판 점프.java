
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static Set<String> set = new HashSet<String>();
	public static String[][] arr = new String[5][5];
	public static int[] dx = {1,-1,0,0};
	public static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<5;i++) {
			String[] temp = br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				arr[i][j]= temp[j];
			}
		}
		
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				dfs(0,i,j,arr[i][j]);
			}
		}
//		for(String item: set) {
//			System.out.println(item);
//		}
		System.out.println(set.size());
	}
	
	public static void dfs(int lev, int x, int y, String temp) {
		
		if(lev==5) {
			set.add(temp);
			return;
		}
		for(int i=0;i<4;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 && ny>=0 && nx<5 && ny<5) {
				dfs(lev+1, nx, ny, temp+arr[nx][ny]);
			}
		}
		
	}
	
}
