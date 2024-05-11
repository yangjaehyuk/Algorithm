
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0;i<n;i++) {
			String[] docs = br.readLine().split(" ");
			String site = docs[0];
			String pw = docs[1];
			map.put(site, pw);
		}
		for(int j=0;j<m;j++) {
			String ans = br.readLine();
			sb.append(map.get(ans)).append("\n");
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

}
