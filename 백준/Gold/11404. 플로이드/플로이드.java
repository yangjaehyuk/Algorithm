import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static int INF = 987654321;
	public static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cities = Integer.parseInt(br.readLine());
		arr = new int[cities+1][cities+1];
		int buses = Integer.parseInt(br.readLine());
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(i==j) {
					arr[i][j] = 0;
					continue;
				}
				arr[i][j] = INF;
 			}
		}
		
		
		for(int i=0;i<buses;i++) {
			String[] docs = br.readLine().split(" ");
			int first = Integer.parseInt(docs[0]);
			int second = Integer.parseInt(docs[1]);
			int weight = Integer.parseInt(docs[2]);
			if(weight < arr[first][second]) {
				arr[first][second] = weight;
			}
		}
		
		floyd(cities);
		for(int i=1;i<=cities;i++) {
			for(int j=1;j<=cities;j++) {
				if(arr[i][j]==INF) arr[i][j] = 0;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void floyd(int n) {
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(arr[i][j]>arr[i][k]+arr[k][j]){
						arr[i][j] = arr[i][k]+arr[k][j];
					}
				}
			}
		}
	}
}
