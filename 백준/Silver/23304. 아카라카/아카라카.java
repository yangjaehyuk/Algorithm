
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String doc = br.readLine();
		int len = doc.length();
		boolean check = true;
		// 첫 펠린드롬 검사
		for(int i=0;i<len/2;i++) {
//			System.out.println(i+" "+(len-i-1));
			if(doc.charAt(i) != doc.charAt(len-i-1)) {
				check = false;
				break;
			}
		}
		if(check) {
			boolean finalCheck = true;
			while(len != 1) {
				len /= 2;
				// 접두사
				for(int i=0;i<len;i++) {
					if(doc.charAt(i) != doc.charAt(len-i-1)) {
						finalCheck = false;
						break;
					}
				}
				
				if(!finalCheck) {
					System.out.println("IPSELENTI");
					return;
				}
			}
			if(finalCheck) {
				System.out.println("AKARAKA");
				return;
			}
		}
		else {
			System.out.println("IPSELENTI");
			return;
		}
	}

}
