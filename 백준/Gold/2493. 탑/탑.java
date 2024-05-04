
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int[] res = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			res[i] = Integer.parseInt(arr[i]);
		}
		Stack<Pair> s = new Stack<>();
		for(int i=0;i<n;i++) {
			while(!s.isEmpty() && s.peek().height <= res[i]) {
				s.pop();
			}
			

			if(s.isEmpty()) System.out.print(0+" ");
			else {
				System.out.print(s.peek().idx+ " ");
			}
			
			s.add(new Pair(res[i], i+1));
			
			
		}
		br.close();
	}
	
	public static class Pair{
		int height;
		int idx;
		Pair(int height, int idx){
			this.height = height;
			this.idx = idx;
		}
	}
}
