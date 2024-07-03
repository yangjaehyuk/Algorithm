import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);
		int amount = 7 * n;
		double res =  (double)amount / (double)(n + m);
		double answer = Math.floor((res*100))/100;
		String toA = String.valueOf(answer);
		int idx = toA.indexOf('.');
		String base = toA.substring(0, idx);
		String tmp = toA.substring(idx);
		if(tmp.length() != 3){
			while(true){
				if(tmp.length() == 3) break;
				tmp += '0';
			}
		}
		String t = base + tmp;
		System.out.println(t);
	}
}