
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int[][][] arr = new int[21][21][21];
	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] arr = br.readLine().split(" ");
			int a = Integer.parseInt(arr[0]);
			int b = Integer.parseInt(arr[1]);
			int c = Integer.parseInt(arr[2]);
			if(a==-1 && b==-1 && c==-1) break;
			int res = w(a,b,c);
			System.out.println("w("+a+", "+b+", "+c+") = "+res);
		}
		
	}
	
	public static int w(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		if(a>20 || b>20 || c>20) return w(20,20,20);
		if(arr[a][b][c]>0) return arr[a][b][c];
		if(a<b && b<c) {
			arr[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
		}
		else {
			
			arr[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
		}
		return arr[a][b][c];
	}

}
