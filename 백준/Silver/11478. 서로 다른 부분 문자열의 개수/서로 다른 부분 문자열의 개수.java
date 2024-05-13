
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		int idx = 1;
		List<String> list = new ArrayList<String>();
		while(true) {
			if(idx == doc.length()+1) break;
			for(int i=0;i<doc.length()-idx+1;i++) {
				list.add(doc.substring(i, i+idx));
			}
			idx++;
		}
		Set<String> set = new HashSet<String>();
		for(String item: list) {
			set.add(item);
		}
		System.out.println(set.size());
	}
}
