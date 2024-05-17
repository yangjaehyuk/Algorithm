import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer int1, Integer int2) {
				// TODO Auto-generated method stub
				if(Math.abs(int1) == Math.abs(int2)) {
					return int1 - int2;
				}
				return Math.abs(int1) - Math.abs(int2);
			}
		});
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(pq.isEmpty()) System.out.println(0);
				else System.out.println(pq.poll());
			}
			else pq.add(num);
		}
	}
}
