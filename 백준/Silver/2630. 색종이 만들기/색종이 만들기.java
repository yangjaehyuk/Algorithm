
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[][] arr;
	public static int white = 0;
	public static int blue = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<tmp.length;j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		dfs(0,0,n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void dfs(int x, int y, int len) {
		int cri = arr[x][y];
		boolean flag = true;
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(arr[i][j] != cri) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
//			System.out.println(x+" "+y+" "+arr[x][y]);
			if(cri == 1) blue++;
			else white++;
			return;
		}
		len/=2;
		dfs(x,y,len);
		dfs(x,y+len,len);
		dfs(x+len,y,len);
		dfs(x+len,y+len,len);
	}
}
