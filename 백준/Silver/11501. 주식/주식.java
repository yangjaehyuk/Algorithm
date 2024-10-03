import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            List<Integer> list = new ArrayList<>();
            int len = Integer.parseInt(br.readLine());
            String[] docs = br.readLine().split(" ");
            for(int j=0;j<docs.length;j++){
                list.add(Integer.parseInt(docs[j]));
            }
            long maxi = 0;
            long sum = 0;
            for(int j=list.size() - 1;j >= 0;j--){
                
                if(maxi < list.get(j)) maxi = list.get(j);
                else{
                    sum += maxi - list.get(j);
                }
            }
            System.out.println(sum);
            
        }
    }
}
