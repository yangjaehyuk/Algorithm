
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] arr = br.readLine().split(":");
		boolean isEight = false;
		int tmp = 0;
		int cnt = 0;
		if(arr.length == 8) {
			isEight = true;
		}
		else {
			for(String item: arr) {
				if(item.length() != 0) tmp++;
			}
			tmp = 8 - tmp;
		}
		if(isEight) {
			for(String item: arr) {
				if(item.length() == 0) {
					sb.append("0000").append(":");
				}
				else {
					if(item.length() == 4) {
						sb.append(item).append(":");
					}
					else {
						for(int j=item.length();j<4;j++) {
							sb.append(0);
						}
						sb.append(item).append(":");
					}
				}
			}
		}
		else {
			for(String item: arr) {
//				System.out.println(item);
				if(item.length() == 0) {
					cnt++;
					if(cnt == 1) {
						for(int j=0;j<tmp;j++) {
							sb.append("0000").append(":");
						}

					}
					
				}
				else if(item.length() > 0) {
					if(item.length() == 4) {
						sb.append(item).append(":");
					}
					else {
						for(int j=item.length();j<4;j++) {
							sb.append(0);
						}
						sb.append(item).append(":");
					}

				}
			}
		}
//		System.out.println(sb.toString().length());
		for(int i=sb.toString().length();i<40;i+=5) {
			sb.append("0000").append(":");
		}
		
//		for(String item: arr) {
//			System.out.println(item);
//			if(item.length() == 0 && tmp > 0) {
//				// ::일때
//				sb.append("0000").append(":");
//				tmp--;
//			}
//			else {
//				if(item.length() == 4) {
//					sb.append(item).append(":");
//				}
//				else {
//					for(int j=item.length();j<4;j++) {
//						sb.append(0);
//					}
//					sb.append(item).append(":");
//				}
//			}
//		}
		System.out.println(sb.toString().substring(0, sb.toString().length()-1));
		
	}

}
