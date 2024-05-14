
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for(int i=0;i<2;i++) {
			String[] tmp = br.readLine().split(" ");
			if(i==1) {
				for(int j=0;j<tmp.length;j++) {
					list1.add(Integer.parseInt(tmp[j]));
				}
			}
			else {
				for(int j=0;j<tmp.length;j++) {
					list2.add(Integer.parseInt(tmp[j]));
				}
			}
		}
		int sum = 0;
		Collections.sort(list1);
		Collections.sort(list2, Collections.reverseOrder());
		for(int i=0;i<list1.size();i++) {
			sum+=list1.get(i)*list2.get(i);
		}
		System.out.println(sum);
	}
}
