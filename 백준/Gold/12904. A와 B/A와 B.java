import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
   public static void main(String[] args) throws Exception{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String s = br.readLine();
      String t = br.readLine();
      StringBuilder sb = new StringBuilder();
      for(int i=0;i<t.length();i++) {
    	  sb.append(t.charAt(i));
      }
      while(true) {
         if(s.length() == sb.toString().length()) break;
         //t 뒤에 a면 맨뒤 빼기
         //t 뒤에 b면 뒤집고 맨앞 b빼기
         if(sb.charAt(sb.length()-1)=='A') {
        	 sb.deleteCharAt(sb.length()-1);
         }
         else if(sb.charAt(sb.length()-1)=='B') {
        	 sb.reverse();
        	 sb.deleteCharAt(0);
         }
      }
      if(s.equals(sb.toString())) System.out.println(1);
      else System.out.println(0);
   }
}