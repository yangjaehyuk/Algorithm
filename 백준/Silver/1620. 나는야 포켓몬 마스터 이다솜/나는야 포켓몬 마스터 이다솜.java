
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);
		HashMap<Integer, String> map1 = new HashMap<Integer, String>();
		HashMap<String, Integer> map2 = new HashMap<String, Integer>();
		for(int i=0;i<n;i++) {
			String pokemon = br.readLine();
			map1.put(i+1, pokemon);
			map2.put(pokemon, i+1);
		}
		for(int i=0;i<m;i++) {
			String tmpV = br.readLine();
			if(Character.isDigit(tmpV.charAt(0))) {
				int nowV = Integer.parseInt(tmpV);
				sb.append(map1.get(nowV)).append("\n");
			}
			else {
				sb.append(map2.get(tmpV)).append("\n");
			}
		}
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
