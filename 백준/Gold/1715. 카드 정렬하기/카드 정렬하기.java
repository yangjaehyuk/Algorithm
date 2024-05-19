
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int sum = 0;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			pq.add(num);
		}
		while(pq.size()>1) {
			int num1 = pq.poll();
			if(pq.isEmpty()) {
				sum+=num1;
			}
			else {
				int num2 = pq.poll();
				int temp = num1+num2;
				sum+=temp;
				pq.add(temp);
			}
		}
		System.out.println(sum);
	}
}
