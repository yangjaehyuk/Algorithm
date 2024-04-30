
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String doc = sc.nextLine();
		List<String> list = new ArrayList<String>();
		for(int i=0;i<doc.length();i++) {
			list.add(doc.substring(i, doc.length()));
		}
		Collections.sort(list);
		for(String item: list) {
			System.out.println(item);
		}
	}
}
