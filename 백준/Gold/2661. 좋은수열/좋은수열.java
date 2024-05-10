
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String path = "";
		dfs(0, n, path);
	}
	
	public static void dfs(int lev, int level, String path) {
		if(lev == level) {
			System.out.println(path);
			System.exit(0);
			
		}
		
		else {
			for(int i=1;i<=3;i++) {
				if(check(path+i)) dfs(lev+1, level, path+i);
			}
		}
		
	}
	
	public static boolean check(String docs) {
	    // 나쁜 순열이면 false를 반환
	    int len = docs.length()/2;
	    for (int i = 1; i <= len; i++) {
            if (docs.substring(docs.length() - i).equals(docs.substring(docs.length() - 2 * i, docs.length() - i))) {
                return false;
            }
        }
	    return true;
	}
}
