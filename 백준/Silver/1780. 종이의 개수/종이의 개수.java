
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[][] arr;
	public static int minusOne = 0;
	public static int zero = 0;
	public static int one = 0;
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
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(one);
	}
	
	public static void dfs(int x, int y, int len) {
		int cri = arr[x][y];
		boolean flag = true;
		for(int i=x;i<x+len;i++) {
			for(int j=y;j<y+len;j++) {
				if(arr[i][j]!=cri) {
					flag=false;
					break;
				}
			}
		}
		if(flag) {
			if(cri == -1) minusOne++;
			else if(cri == 0) zero++;
			else one++;
			return;
		}
		
		len/=3;
		// 9분할하기
		dfs(x,y,len);
		dfs(x,y+len,len);
		dfs(x,y+len*2,len);
		
		dfs(x+len,y,len);
		dfs(x+len,y+len,len);
		dfs(x+len,y+len*2,len);
		
		dfs(x+len*2,y,len);
		dfs(x+len*2,y+len,len);
		dfs(x+len*2,y+len*2,len);
		
	}
}
