

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		for(int i=0;i<n;i++) {
			int tmp = Integer.parseInt(br.readLine());
			list[i] = tmp;
		}
		br.close();
		Arrays.sort(list);
		for(int i=0;i<n;i++) {
			bw.write(list[i]+"\n");
		}
		bw.flush();
		bw.close();
	}
	
}
