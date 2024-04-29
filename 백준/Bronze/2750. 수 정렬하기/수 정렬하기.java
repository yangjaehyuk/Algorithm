
import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int n = sc.nextInt();
		for(int i=0;i<n;i++) {
			int tmp = sc.nextInt();
			list.add(tmp);
		}
		Collections.sort(list);
		for(Integer item: list) {
			System.out.println(item);
		}
	}

}
