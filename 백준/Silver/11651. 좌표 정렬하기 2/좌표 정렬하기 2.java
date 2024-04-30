
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Pair> list = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			list.add(new Pair(x,y));
		}
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair p1, Pair p2) {
				// TODO Auto-generated method stub
				if(p1.y == p2.y) {
					return p1.x - p2.x;
				}
				return p1.y - p2.y;
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
