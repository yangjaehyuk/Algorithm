import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>();         
        for (int i = 0; i < num; i++) {             
            String[] tmp = br.readLine().split(" ");             
            int first = Integer.parseInt(tmp[0]);             
            int second = Integer.parseInt(tmp[1]);             
            list.add(new Pair(first, second));         
        }
        Collections.sort(list, new Comparator<Pair>() {             
            @Override             
            public int compare(Pair x, Pair y) {
                if(x.y==y.y) return x.x-y.x;
                return x.y - y.y;
            }         
        });
        // for(Pair p: list){
        //     System.out.println(p.x+" "+p.y);
        // }
        
        int end = list.get(0).y;
        int cnt = 1;
        
        for(int i=1;i<num;i++){
           if(end <= list.get(i).x){
               end = list.get(i).y;
               cnt++;
           }
        }
        
        System.out.println(cnt);
        
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
