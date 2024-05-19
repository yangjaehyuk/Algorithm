
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int sum = 0;
		PriorityQueue<Integer> pqp = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
		PriorityQueue<Integer> pqm = new PriorityQueue<Integer>();
		List<Integer> r = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			r.add(num);
			if(num>0) pqp.add(num);
			else pqm.add(num);
		}
		if(r.size()==1) {
			System.out.println(r.get(0));
			return;
		}
		else {
			if(pqp.size()>0) {
				while(!pqp.isEmpty()) {
					int num1 = pqp.poll();
					if(pqp.isEmpty()) {
						sum+=num1;
					}
					else {
						int num2 = pqp.poll();
						if(num1 == 1 || num2 == 1) {
							sum += num1 + num2;
						}
						else sum+=num1*num2;
					}
//					System.out.println(sum);
				}
			}
			if(pqm.size()>0) {
				while(!pqm.isEmpty()) {
					int num1 = pqm.poll();
					if(pqm.isEmpty()) {
						sum+=num1;
					}
					else {
						int num2 = pqm.poll();
						sum+=num1*num2;
					}
				}
//				System.out.println(sum);
			}
		}
		System.out.println(sum);
	}
}
