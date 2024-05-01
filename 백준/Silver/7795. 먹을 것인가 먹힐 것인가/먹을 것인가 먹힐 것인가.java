

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			int ans = 0;
			String[] num = br.readLine().split(" ");
			int a = Integer.parseInt(num[0]);
			int b = Integer.parseInt(num[1]);
			List<Integer> listA = new ArrayList<Integer>();
			List<Integer> listB = new ArrayList<Integer>();
			String[] aDoc = br.readLine().split(" ");
			String[] bDoc = br.readLine().split(" ");
			for(int j=0;j<aDoc.length;j++) {
				listA.add(Integer.parseInt(aDoc[j]));
				
			}
			for(int j=0;j<bDoc.length;j++) {
				listB.add(Integer.parseInt(bDoc[j]));
				
			}
			Collections.sort(listB);
			for(int j=0;j<listA.size();j++) {
				int left = 0;
				int right = listB.size()-1;
				int cnt = 0;
				while(left<=right) {
					int mid = (left + right)/2;
					if(listA.get(j)<=listB.get(mid)) {
						right = mid-1;
					}
					else {
						left = mid+1;
						cnt = mid+1;
					}
				}
				ans+=cnt;
			}
			
			System.out.println(ans);
		}
	}
}
