
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		String[] tmp = br.readLine().split(" ");
		for(int i=0;i<tmp.length;i++) {
			list.add(Integer.parseInt(tmp[i]));
		}
		Collections.sort(list);
		int sum = 0;
		int res = 0;
		for(Integer item: list) {
			sum+=item;
			res+=sum;
		}
		System.out.println(res);
	}
}
