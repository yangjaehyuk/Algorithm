

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	public static int idx;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<Integer>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			String[] doc = br.readLine().split(" ");
			if(doc.length>1) {
				int num = Integer.parseInt(doc[1]);
				q.add(num);
				idx = num;
			}
			else {
				if(doc[0].equals("pop")) {
					if(q.isEmpty()) sb.append(-1).append("\n");
					else {
						int front = q.poll();
						sb.append(front).append("\n");
					}
				}
				else if(doc[0].equals("size")) {
					sb.append(q.size()).append("\n");
					
				}
				else if(doc[0].equals("empty")) {
					if(q.isEmpty()) sb.append(1).append("\n");
					else sb.append(0).append("\n");
					
				}
				else if(doc[0].equals("front")) {
					if(q.isEmpty()) sb.append("-1").append("\n");
					else {
						sb.append(q.peek()).append("\n");
					}
				}
				else {
					if(q.isEmpty()) sb.append("-1").append("\n");
					else {
						sb.append(idx).append("\n");
					}
					
				}
			}
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
