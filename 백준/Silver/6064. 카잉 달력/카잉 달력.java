
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		for(int i=0;i<num;i++) {
			String[] docs = br.readLine().split(" ");
			int m = Integer.parseInt(docs[0]);
			int n = Integer.parseInt(docs[1]);
			int x = Integer.parseInt(docs[2]);
			int y = Integer.parseInt(docs[3]);
			int res = ans(m,n,x,y);
			System.out.println(res);
		}
	}
	
	public static int ans(int m, int n, int x, int y) {
		while(x<=m*n) {
			if((x-y)%n==0) return x;
			x+=m;
		}
		return -1;
	}
	
}
