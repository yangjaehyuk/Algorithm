
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Pair> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split(" ");
			int age = Integer.parseInt(arr[0]);
			String name = arr[1];
			list.add(new Pair(age, name, i));
		}
		Collections.sort(list, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if(o1.age != o2.age) {
					return o1.age - o2.age;
				}
				return o1.th - o2.th;
			}
		});
		for(Pair p: list) {
			System.out.println(p.age+" "+p.name);
		}
	}
	
	public static class Pair{
		int age;
		String name;
		int th;
		Pair(int age, String name, int th){
			this.age = age;
			this.name = name;
			this.th = th;
		}
	}

}
