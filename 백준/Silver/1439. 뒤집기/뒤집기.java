
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		String[] num0 = tmp.split("1");
		String[] num1 = tmp.split("0");
		Arrays.sort(num1);
		Arrays.sort(num0);
		int one = 0;
		int zero = 0;
		for(int i=num1.length-1;i>=0;i--) {
			if(num1[i].length()==0) break;
			one++;
		}
		for(int i=num0.length-1;i>=0;i--) {
			if(num0[i].length()==0) break;
			zero++;
		}
		System.out.println(Math.min(one, zero));
	}
}
