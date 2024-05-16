
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		long sum = 0;
		String[] value = br.readLine().split(" ");
		PriorityQueue<Long> q = new PriorityQueue<Long>();
		for(String item: value) {
			q.offer(Long.parseLong(item));
		}
		for(int i=0;i<m;i++) {
			long tmpV = q.poll()+q.poll();
			q.offer(tmpV);
			q.offer(tmpV);
		}
		for(Long item: q) {
			sum+=item;
		}
		System.out.println(sum);
	}
}
