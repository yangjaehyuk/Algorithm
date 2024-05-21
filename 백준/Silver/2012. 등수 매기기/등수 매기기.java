
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i] = num;
		}
		long sum = 0;
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
			int now = i+1;
			sum+=Math.abs(now-arr[i]);
		}
		System.out.println(sum);
	}
}
