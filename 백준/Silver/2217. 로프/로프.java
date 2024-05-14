
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception{
		// k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때, 각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int maxi = 0;
		int idx = 1;
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {
			int tmpV = Integer.parseInt(br.readLine());
			list.add(tmpV);
		}
		Collections.sort(list);
		for(int j=list.size()-1;j>=0;j--) {
			int temp = list.get(j)*idx;
			if(maxi<temp) maxi = temp;
			idx++;
		}
		System.out.println(maxi);
	}
}
