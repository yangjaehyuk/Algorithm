
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		
		System.out.println(dfs(a,b,c));
	}
	
	public static long dfs(long a, long b, long c) {
		if(b==1) return a%c;
		else {
			long tmp = dfs(a, b/2, c);
			if(b%2==0) {
				// 지수 짝수
				return (tmp*tmp)%c;
			}
			else {
				return (tmp*tmp)%c*a%c;
			}
		}
	}
}
