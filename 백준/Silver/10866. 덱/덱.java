

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Deque<Integer> d = new ArrayDeque<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split(" ");
			if(arr.length>1) {
				int num = Integer.parseInt(arr[1]);
				if(arr[0].equals("push_back")) {
					d.addLast(num);
				}
				else {
					d.addFirst(num);
				}
			}
			else {
				if(arr[0].equals("pop_front")) {
					if(d.isEmpty()) System.out.println(-1);
					else System.out.println(d.pollFirst());
				}
				else if(arr[0].equals("pop_back")) {
					if(d.isEmpty()) System.out.println(-1);
					else System.out.println(d.pollLast());
				}
				else if(arr[0].equals("size")) {
					System.out.println(d.size());
				}
				else if(arr[0].equals("empty")) {
					if(d.isEmpty()) System.out.println(1);
					else System.out.println(0);
				}
				else if(arr[0].equals("front")) {
					if(d.isEmpty()) System.out.println(-1);
					else System.out.println(d.getFirst());
				}
				else {
					if(d.isEmpty()) System.out.println(-1);
					else System.out.println(d.getLast());
				}
			}
		}
	}

}
