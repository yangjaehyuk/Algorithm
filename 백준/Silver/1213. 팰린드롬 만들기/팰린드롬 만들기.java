
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String input = sc.next();
		
		int[] alphabet = new int[26];
		
		for(int i = 0; i < input.length(); i++) {
			alphabet[input.charAt(i) - 'A']++;
		}
		
		int oddCount = 0;
		char oddChar = ' ';
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] % 2 == 1) {
				oddCount++;
				oddChar = (char)(i + 65);
			}
			
			if(oddCount == 2) break;
		}
		
		String answer = "";
		if(oddCount == 2) {
			answer = "I'm Sorry Hansoo";
		} else {
			String front = "";
			String tail = "";
			
			for(int i = 0; i < 26; i++) {
				if(alphabet[i] >= 2) {
					for(int j = 0; j < alphabet[i] / 2; j++) {
						front += (char)(i + 65);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder(front);
			tail = sb.reverse().toString();
			
			if(oddCount == 0) {
				answer = front + tail;
			}else if(oddCount == 1){
				answer = front + oddChar + tail;
			}
		}
		
		
		System.out.println(answer);
	}

}