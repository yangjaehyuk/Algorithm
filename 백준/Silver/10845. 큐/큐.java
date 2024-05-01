

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			String[] arr = br.readLine().split(" ");
			if(arr.length>1) {
				int num = Integer.parseInt(arr[1]);
				q.add(num);
				list.add(num);
			}
			else {
				if(arr[0].equals("front")) {
					if(q.isEmpty()) System.out.println(-1);
					else System.out.println(q.peek());
				}
				else if(arr[0].equals("back")) {
					if(q.isEmpty()) System.out.println(-1);
					else {
						System.out.println(list.get(list.size()-1));
					}
				}
				else if(arr[0].equals("size")) System.out.println(q.size());
				else if(arr[0].equals("empty")) {
					if(q.isEmpty()) System.out.println(1);
					else System.out.println(0);
				}
				else {
					if(q.isEmpty()) System.out.println(-1);
					else {
						System.out.println(q.poll());
					}
				}
			}
		}
	}

}
