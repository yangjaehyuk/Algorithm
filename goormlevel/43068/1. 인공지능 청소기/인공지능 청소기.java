import java.io.*;
import java.util.*;
class Main {
	// x, y, n
	// 초기 0, 0
	// n초 뒤 도착할 수 있으면 yes
	// 아니면 no
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++){
			int[] arr = new int[3];
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<3;j++){
				arr[j] = Integer.parseInt(tmp[j]);
			}
			if(Math.abs(arr[0]) + Math.abs(arr[1]) > arr[2]){
				System.out.println("NO");
			}
			else{
				int res = arr[2] - Math.abs(arr[0]) + Math.abs(arr[1]);
				if(res == 0 || res % 2 == 0){
					System.out.println("YES");
				}
				else System.out.println("NO");
			}
		}
		
		
	}
}