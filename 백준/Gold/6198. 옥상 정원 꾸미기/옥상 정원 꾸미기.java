
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long ans = 0;
		Stack<Long> s = new Stack<>();
		for(int i=0;i<n;i++) {
			long num = Long.parseLong(br.readLine());
			while(!s.empty() && s.peek() <= num) {
//				System.out.println(s.peek()+" "+num);

//				if(s.peek()>num) ans++;
				s.pop();
//				System.out.println(s.peek());
//				ans++;
				ans+=s.size();

			}
		
			s.push(num);
		}
		while(!s.isEmpty()) {
			s.pop();
			ans+=s.size();
		}
		
//		System.out.println(s.size());
		System.out.println(ans);
	}

}
