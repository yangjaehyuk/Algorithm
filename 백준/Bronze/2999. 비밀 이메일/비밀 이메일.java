
import java.util.Scanner;

public class Main {
	public static char[][] res;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String doc = sc.next();
		int R = 0;
		int C = 0;
		int idx = 0;
		for(int i=1;i<=doc.length();i++) {
			if(doc.length() % i == 0) {
				if(i <= doc.length()/i) {
					R = Math.max(R, i);
				}
			}
		}
		C = doc.length() / R;
		res = new char[R][C];
//		System.out.println(R+" "+C);
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				res[j][i] = doc.charAt(idx);
				idx++;
			}
		}
		for(int i=0;i<res.length;i++) {
			for(int j=0;j<res[i].length;j++) {
				System.out.print(res[i][j]);
			}
		}
	}

}
