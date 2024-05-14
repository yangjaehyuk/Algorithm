
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static Map<Long, Long> map = new HashMap<>();
	public static long n;
	public static long p;
	public static long q;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		n = Long.parseLong(tmp[0]);
		p = Long.parseLong(tmp[1]);
		q = Long.parseLong(tmp[2]);
//		A0 = 1
//		Ai = A⌊i/P⌋ + A⌊i/Q⌋ (i ≥ 1)
//		N, P와 Q가 주어질 때, AN을 구하는 프로그램을 작성
//		⌊x⌋는 x를 넘지 않는 가장 큰 정수이다.
		
//		7 2 3 -> 7
		long res = solve(n,p,q);
		System.out.println(res);
		
	}
	
	public static long solve(long n, long p, long q) {
		if(n==0) return 1;
		if(map.containsKey(n)) return map.get(n);
		long front = n/p;
		long back = n/q;
		
		map.put(n, solve(front, p, q)+solve(back, p, q));
		return map.get(n);
	}
}
