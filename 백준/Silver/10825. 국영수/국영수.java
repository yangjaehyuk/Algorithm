
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<Pair>();
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split(" ");
			String name = arr[0];
			int kor = Integer.parseInt(arr[1]);
			int eng = Integer.parseInt(arr[2]);
			int math = Integer.parseInt(arr[3]);
			list.add(new Pair(name, kor, eng, math));
		}
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				if(o1.k == o2.k) {
					if(o1.e == o2.e) {
						if(o1.m == o2.m) {
							return o1.n.compareTo(o2.n);
						}
						else {
							return Integer.compare(o1.m, o2.m) * -1;
						}
					}
					else {
						return Integer.compare(o1.e, o2.e) ;
					}
				}
				return Integer.compare(o1.k, o2.k) * -1;
			}
		});
		for(Pair p: list) {
			System.out.println(p.n);
		}
	}
	
	public static class Pair{
		String n;
		int k;
		int e;
		int m;
		Pair(String n, int k, int e, int m){
			this.n = n;
			this.k = k;
			this.e = e;
			this.m = m;
		}
	}

}
