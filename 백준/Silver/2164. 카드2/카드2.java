
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<Integer>();
		for(int i=1;i<=n;i++) {
			q.add(i);
		}
		while(q.size() != 1) {
			q.poll();
			int front = q.poll();
			q.add(front);
		}
		br.close();
		System.out.println(q.peek());
	}
}
