
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> comp = new ArrayList<Integer>();
		int cnt = 0;
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
			comp.add(num);
		}
		for(int i=list.size()-1;i>0;i--) {
			if(list.get(i)>list.get(i-1)) continue;
			else {
				while(true) {
					if(list.get(i)>list.get(i-1)) break;
					else {
						int tmp = list.get(i);
						list.set(i-1, tmp-=1);
					}
				}
			}
		}
		for(int i=0;i<list.size();i++) {
			cnt+=comp.get(i)-list.get(i);
		}
		System.out.println(cnt);
	}
}
