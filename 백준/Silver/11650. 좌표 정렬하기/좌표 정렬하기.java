import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Pair> list = new ArrayList<Pair>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			// x 좌표를 증가하는 순으로
			// x 좌표가 같으면 y 좌표가 증가하는 순으로
			list.add(new Pair(x, y));
		}
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				if(o1.x == o2.x) {
					return o1.y - o2.y;
				}
				else {
					return o1.x - o2.x;
				}
			}
			
		});
		for(Pair p: list) {
			System.out.println(p.x+" "+p.y);
		}
	}
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}
