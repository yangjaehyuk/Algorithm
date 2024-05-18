
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
			
		});
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j=0;j<tmp.length;j++) {
				int num = Integer.parseInt(tmp[j]);
				pq.add(num);
				
			}
		}
		int cnt = 0;
		while(!pq.isEmpty()) {
			cnt++;
			if(cnt==n) System.out.println(pq.poll());
//			System.out.println(pq.poll());
			else pq.poll();
		}
	}
}
