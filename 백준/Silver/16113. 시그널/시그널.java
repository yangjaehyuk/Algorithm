
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		// 시그널은 항상 5의 배수
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String doc = sc.nextLine();
		int len = doc.length()/5;
		char[][] arr = new char[5][len];
		int idx = 0;
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<len;j++) {
				arr[i][j] = doc.charAt(idx);
				idx ++;
			}
		}
		
//		for(int i=0;i<5;i++) {
//			for(int j=0;j<len+4;j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,1,-1};
		boolean[][] visited = new boolean[5][len];
		Queue<Pair> q = new LinkedList<Pair>();
		for(int i1=0;i1<1;i1++) {
			for(int j=0;j<len;j++) {
				if(arr[i1][j] == '#' && !visited[i1][j]) {
					int cnt = 0;
					q.add(new Pair(i1, j));
					while(!q.isEmpty()) {
						Pair p = q.poll();
						int x = p.x;
						int y = p.y;
						for(int k=0;k<4;k++) {
							int nx = x+dx[k];
							int ny = y+dy[k];
							if(nx>=0 && ny>=0 && nx<5 && ny<len && arr[nx][ny] == '#' && !visited[nx][ny]) {
								visited[nx][ny] = true;
								cnt++;
								q.add(new Pair(nx, ny));
							}
						}
					}
					if(cnt == 5) sb.append(1);
					else if(cnt == 7) sb.append(7);
					else if(cnt == 9) sb.append(4);
					else if(cnt == 11) {
						// 2 3 5
						if(arr[i1+1][j] == '.' && arr[i1+1][j+1] == '.' && arr[i1+3][j+1] == '.' && arr[i1+3][j+2] == '.') {
							sb.append(2);
						}
						else if(arr[i1+1][j] == '.' && arr[i1+1][j+1] == '.' && arr[i1+3][j] == '.' && arr[i1+3][j+1] == '.') {
							sb.append(3);
						}
						else sb.append(5);
					}
					else if(cnt == 12) {
						// 0 6 9
						if(arr[i1+1][j+1] == '.' && arr[i1+2][j+1] == '.' && arr[i1+3][j+1] == '.') {
							sb.append(0);
						}
						else if(arr[i1+1][j+1] == '.' && arr[i1+1][j+2] == '.' && arr[i1+3][j+1] == '.') {
							sb.append(6);
						}
						else sb.append(9);
						
					}
					else sb.append(8);
				}
			}
		}
		System.out.println(sb.toString());
	}
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
