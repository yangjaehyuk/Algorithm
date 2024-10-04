import java.io.*;
import java.util.*;

public class Main {
    static Set<Character> set = new HashSet<>();
    static int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] path;
    static int maxi = 0;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String ans = br.readLine(); 
            for (int j = 0; j < ans.length(); j++) {
                set.add(ans.charAt(j)); 
            }
            list.add(ans);
        }
        
        List<Character> lis = new ArrayList<>(set);  
        path = new int[lis.size()];  
        visited = new boolean[10];   
        
        dfs(0, lis.size(), list, lis);
        System.out.println(maxi);
    }

    public static void dfs(int lev, int level, List<String> list, List<Character> lis) {
        if (lev == level) {
            Map<Character, Integer> map = new HashMap<>();
            
            for (int i = 0; i < level; i++) {
                map.put(lis.get(i), path[i]);
            }

            int sum = 0;
            for (String s : list) {
                int num = 0;
                for (int i = 0; i < s.length(); i++) {
                    num = num * 10 + map.get(s.charAt(i));
                }
                sum += num;
            }
            if (sum > maxi) maxi = sum;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!visited[i]) {
                path[lev] = arr[i];
                visited[i] = true;
                dfs(lev + 1, level, list, lis);
                visited[i] = false; 
            }
        }
    }
}
