
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			List<Long> list = new ArrayList<Long>();
			int num = Integer.parseInt(br.readLine());
			long sum = 0;
			long maxi = 0;
			String[] tmp = br.readLine().split(" ");
			for(String item: tmp) {
				list.add(Long.parseLong(item));
			}
			for(int j=list.size()-1;j>=0;j--) {
				if(maxi<list.get(j)) maxi = list.get(j);
				else {
					sum+=maxi-list.get(j);
				}
			}
			System.out.println(sum);
		}
	}
}
