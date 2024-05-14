
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int cnt = 0;
		List<Integer> list = new ArrayList<Integer>();
		int n = Integer.parseInt(tmp[0]);
		int k = Integer.parseInt(tmp[1]);
		for(int i=0;i<n;i++) {
			int coin = Integer.parseInt(br.readLine());
			list.add(coin);
		}
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i)<=k && k!=0) {
				int tmpV = k/list.get(i);
				cnt += tmpV;
				k-=tmpV*list.get(i);
			}
//			System.out.println(k);
		}
		System.out.println(cnt);
	}
}
