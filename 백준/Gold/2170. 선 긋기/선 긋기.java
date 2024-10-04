import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            String[] docs = br.readLine().split(" ");
            list.add(new Pair(Integer.parseInt(docs[0]), Integer.parseInt(docs[1])));
        }
        Collections.sort(list, new Comparator<Pair>() {
           @Override
           public int compare(Pair p1, Pair p2){
               return p1.x - p2.x;
           }
            
        });
        
        // for(Pair p: list){
        //     System.out.println(p.x + " " + p.y);
        // }
        
        int sum = 0;
        int end = list.get(0).y;
        int start = list.get(0).x;
        for(int i=1;i<num;i++){
            if(end < list.get(i).x){
                sum += end - start;
                start = list.get(i).x;
                end = list.get(i).y;
            }
            else{
                if(end < list.get(i).y){
                    end = list.get(i).y;
                }
            }
        }
        sum += end - start;
        System.out.println(sum);
    }
    
    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
}
