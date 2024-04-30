
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			arr[i] = tmp;
		}
		br.close();
		Arrays.sort(arr);
		for(int i=0;i<n;i++) {
			bw.write(arr[i]+"\n");
		}
		bw.flush();
		bw.close();
	}

}
