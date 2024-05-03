
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static String doc;
	public static boolean[] visited;
	public static char[] arr;
	public static int[] nums;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// _ _ _ _
		// false false false false
		// zoac
		// a -> zoac에서도 2번째 인덱스 자리이므로 
		// ac
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		doc = br.readLine();
		nums = new int[doc.length()];
		for(int i=0;i<doc.length();i++) {
			nums[i] = (int)doc.charAt(i);
		}
		arr = new char[doc.length()];
		visited = new boolean[doc.length()];
		zoac(0, doc.length()-1);
		
	}
	
	public static void zoac(int left, int right) {
		if(left > right) return;
		int idx = left;
		int mini = 999;
		for(int i=left; i<=right; i++) {
			if(!visited[i] && mini>nums[i]) {
				mini = nums[i];
				idx = i;
			}
		}
		for(int i=left;i<=right;i++) {
			if(!visited[i]) {
				if(mini == nums[i]) {
					arr[idx] = doc.charAt(idx);
					visited[idx] = true;
					break;
				}
			}
		}
		// 출력
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>='A' && arr[i]<='Z') System.out.print(arr[i]);
		}
		System.out.println();
		zoac(idx+1,right);
		zoac(left,idx-1);
	}
	
	

}