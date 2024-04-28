import java.util.*;

public class Main {
	public static String doc;
	public static String[] sarr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> soundList = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<t;i++) {
			StringBuilder sb = new StringBuilder();
			doc = sc.nextLine();
			sarr = doc.split(" ");
			while(true) {
				String tmp = sc.nextLine();
				if(tmp.equals("what does the fox say?")) break;
				int idx = tmp.indexOf("goes");
				String sound = tmp.substring(idx+5);
				soundList.add(sound);
			}
			List<String> s_list = new ArrayList<>(Arrays.asList(sarr));
			for(String sound: soundList) {
				Iterator<String> iterator = s_list.iterator();
				while (iterator.hasNext()) {
				    String word = iterator.next();
				    if (word.equals(sound)) {
				        iterator.remove();
				    }
				}
				
			}
			for(int j=0;j<s_list.size();j++) {
				System.out.print(s_list.get(j)+" ");
			}
		}
		
	}

}
