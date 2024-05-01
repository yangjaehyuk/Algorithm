import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		int n = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			list.add(str);
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// o1과 o2의 길이가 다르면 짧은 것이 먼저 온다.
				if(o1.length() != o2.length()) {
					return o1.length() - o2.length();
				}
				// 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
				else if(o1.length() == o2.length()) {
					int cnt1 = 0;
					int cnt2 = 0;
					for(int i=0;i<o1.length();i++) {
						if(Character.isDigit(o1.charAt(i))) {
							cnt1 += o1.charAt(i) - '0';
						}
					}
					for(int i=0;i<o2.length();i++) {
						if(Character.isDigit(o2.charAt(i))) {
							cnt2 += o2.charAt(i) - '0';
						}
					}
					if(cnt1==cnt2) return o1.compareTo(o2);
					else return cnt1 - cnt2;
					
				
			}
				return 1;
			
		}});
		for(String item: list) {
			System.out.println(item);
		}
	}

}
