
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0;i<t;i++) {
			String menus = br.readLine();
			int len = Integer.parseInt(br.readLine());
			String array = br.readLine();
			System.out.println(ac(menus, len, array));
		}
	}
	
	public static String ac(String menus, int len, String array) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Deque<Integer> d = new ArrayDeque<Integer>();
		// 길이가 0인것
		if(len == 0) {
			for(int i=0;i<menus.length();i++) {
				if(menus.charAt(i) == 'D') {
					return "error";
				}
			}
			return "[]";
		}
		else {
			// 0이 아닌 것
			boolean flag = false;
			StringBuilder sb = new StringBuilder();
			StringBuilder ans = new StringBuilder();
			// 덱 채우기
			for(int i=0;i<array.length();i++) {
				if(array.charAt(i)!='[' && array.charAt(i)!=']') {
					sb.append(array.charAt(i));
				}
			}
			String[] arr = sb.toString().split(",");
			for(String t: arr) {
				d.add(Integer.parseInt(t));
			}
			
			for(int i=0;i<menus.length();i++) {
				if(menus.charAt(i)=='R') {
					flag = !flag;
					
				}
				else {
					if(d.isEmpty()) {
						return "error";
					}
					else {
						if(flag==true) d.removeLast();
						else d.removeFirst();
					}
					
				}
			}
			if(flag) {
				// 역방향 출력
//				System.out.print('[');
//				bw.write('[');
				ans.append('[');
				while(!d.isEmpty()) {
//					if(d.size()==1) System.out.print(d.pollFirst());
//					if(d.size()==1) bw.write(d.pollFirst());
					if(d.size()==1) ans.append(d.pollFirst());
//					else System.out.print(d.pollLast()+",");
//					else bw.write(d.pollLast()+',');
					else ans.append(d.pollLast()).append(",");
				}
//				System.out.println(']');
//				bw.write(']');
				ans.append(']');
				
			}
			else {
				// 정방향 출력
//				System.out.print('[');
//				bw.write('[');
				ans.append('[');
				while(!d.isEmpty()) {
//					if(d.size()==1) System.out.print(d.pollFirst());
//					if(d.size()==1) bw.write(d.pollFirst());
					if(d.size()==1) ans.append(d.pollFirst());
//					else {
//						System.out.print(d.pollFirst()+",");	
//					}
//					else bw.write(d.pollFirst()+",");
					else ans.append(d.pollFirst()).append(",");
				}
//				System.out.println(']');
//				bw.write(']');
				ans.append(']');
				
			}
			return ans.toString();
		}
	}

}
