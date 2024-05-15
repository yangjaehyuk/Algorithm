
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split("-");
		int sum = 0;
		int cnt = 0;
//		for(String item: tmp) {
//			System.out.println(item);
//		}
		for(String item: tmp) {
			cnt++;
			int temp = 0;
			String[] add = item.split("\\+");
			for(int i=0;i<add.length;i++) {
				temp += Integer.parseInt(add[i]);
			}
			if(cnt==1) sum+=temp;
			else sum-=temp;
//			System.out.println(temp);
			
		}
		System.out.println(sum);
	}
}
