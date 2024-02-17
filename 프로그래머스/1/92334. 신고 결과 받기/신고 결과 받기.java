import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, Integer> list = new HashMap<>();
        List<String> criminal = new ArrayList<>();
        HashMap<String, Integer> ans = new HashMap<>();
        for(String name: id_list){
            map.put(name, new HashSet<>());
            list.put(name, 0);
        }
        for(int i=0;i<report.length;i++){
            int idx = report[i].indexOf(" ");
            String from = report[i].substring(0,idx);
            String to = report[i].substring(idx+1);
            map.get(from).add(to);
        }
        for(int i=0;i<id_list.length;i++){
            for(String name: map.get(id_list[i])){
                int val = list.get(name);
                list.put(name,++val);
            }
        }
        for(String name: list.keySet()){
            if(list.get(name)>=k){
                criminal.add(name);
            }
        }
        for(String name: map.keySet()){
            int val=0;
            int check = 0;
            for(String cri: criminal){
                if(map.get(name).contains(cri)){
                    ans.put(name, ++val);
                    check++;
                }
            }
            if(check==0){
                ans.put(name,0);
            }
        }
        for(int i=0;i<id_list.length;i++){
            answer[i]=ans.get(id_list[i]);
        }
        return answer;
    }
}