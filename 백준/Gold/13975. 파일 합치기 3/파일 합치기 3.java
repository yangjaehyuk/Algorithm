
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			PriorityQueue<Long> pq1 = new PriorityQueue<Long>();
			int num = Integer.parseInt(br.readLine());
			long sum = 0;
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<tmp.length;j++) {
				pq1.add(Long.parseLong(tmp[j]));
			}
			while(pq1.size()>1) {
				long temp = pq1.poll() + pq1.peek();
				sum += temp;
				pq1.poll();
				pq1.add(temp);
			}
			System.out.println(sum);
		}
	}
}
