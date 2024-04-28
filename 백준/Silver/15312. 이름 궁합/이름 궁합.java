import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		int[] cnt= {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		Map<Character, Integer> map = new HashMap<>();
		int alpha = 65;
		for(int i=0;i<cnt.length;i++) {
			map.put((char)alpha, cnt[i]);
			alpha++;
		}
		List<Character> list = new ArrayList<Character>();
		for(int i=0;i<(A.length()+B.length())/2;i++) {
			list.add(A.charAt(i));
			list.add(B.charAt(i));
		}
		List<Integer> tmp = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			tmp.add(map.get(list.get(i)));
		}
		while(true) {
			List<Integer> change = new ArrayList<Integer>();
			if(tmp.size() == 2) break;
			for(int j=0;j<tmp.size()-1;j++) {
				int res = (tmp.get(j) + tmp.get(j+1)) % 10;
				
				change.add(res);
			}
			tmp = change;
			
		}
		for(int i=0;i<tmp.size();i++) {
			System.out.print(tmp.get(i));
		}
	}

}
