import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Deque<Integer> d1 = new ArrayDeque<Integer>(); // 왼쪽
		Deque<Integer> d2 = new ArrayDeque<Integer>(); // 오른쪽
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] doc = br.readLine().split(" ");
		int n = Integer.parseInt(doc[0]);
		int m = Integer.parseInt(doc[1]);
		String[] nums = br.readLine().split(" ");
		int ans = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<nums.length;i++) {
			list.add(Integer.parseInt(nums[i]));
		}
		for(int i=1;i<=n;i++) {
			d1.add(i);
			d2.add(i);
		}
		for(int i=0;i<list.size();i++) {
			int cnt1 = 0;
			int cnt2 = 0;
			
				// 왼쪽
				while(true) {
					if(d1.getFirst().equals(list.get(i))) {
//						System.out.println(cnt1);
						d1.removeFirst();
						break;
					}
					int now =d1.removeFirst();
					d1.addLast(now);
					cnt1++;
				}
				
				// 오른쪽
				while(true) {
					if(d2.getFirst().equals(list.get(i))) {
//						System.out.println("this"+cnt2);
						d2.removeFirst();
						break;
					}
					int now = d2.removeLast();
					d2.addFirst(now);
					cnt2++;
				}
				
//				System.out.println(cnt1+" "+cnt2);
				ans += Math.min(cnt1, cnt2);
			
		}
		System.out.println(ans);
	}

}
