
import java.util.Scanner;

public class Main {
	public static int res;
	public static int r;
	public static int c;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		res = 0;
		r = sc.nextInt();
		c = sc.nextInt();
		dfs(0,0,(int)Math.pow(2, n));
	}
	
	public static void dfs(int x, int y, int len) {
		len/=2;
		if(x==r && y==c) {
			System.out.println(res);
			return;
		}
		if(x+len>r && y+len>c) {
			dfs(x,y,len);
		}
		else if(x+len>r && c>=y+len) {
			res += len * len;
			dfs(x, y+len, len);
		}
		else if(x+len<=r && c<len+y) {
			res += len * len * 2;
			dfs(x+len, y, len);
		}
		else if(x+len<=r && c>=len+y) {
			res += len * len *3;
			dfs(x+len, y+len, len);
		}
	}
}
