
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long now = 0;
		long sum = 0;
		int n = Integer.parseInt(br.readLine());
		List<Long> roadL = new ArrayList<Long>();
		List<Long> priceL = new ArrayList<Long>();
		String[] road = br.readLine().split(" ");
		String[] price = br.readLine().split(" ");
		for(String item: road) {
			roadL.add(Long.parseLong(item));
		}
		for(String item: price) {
			priceL.add(Long.parseLong(item));
		}
		int idx = 0;
		while(true) {
			if(idx==price.length-1) break;
			if(sum==0) {
				sum+=roadL.get(idx)*priceL.get(idx);
				now=priceL.get(idx);
				idx++;
			}
			else {
				if(priceL.get(idx)<now) {
					sum+=roadL.get(idx)*priceL.get(idx);
					now=priceL.get(idx);
					idx++;
				}
				else {
					sum+=now*roadL.get(idx);
					idx++;
				}
			}
		}
		System.out.println(sum);
		
	}
}
