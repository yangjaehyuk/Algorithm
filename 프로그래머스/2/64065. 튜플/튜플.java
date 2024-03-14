import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        char[] arr = s.toCharArray();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char item: arr){
            if(item == ','){
                if(sb.length()>0){
                    tmp.add(Integer.parseInt(sb.toString()));
                }
                sb.setLength(0);
            }
            else if(item=='{'){
                continue;
            }
            else if(item=='}'){
                if(sb.length()>0){
                    tmp.add(Integer.parseInt(sb.toString()));
                }
                list.add(new ArrayList<>(tmp));
                tmp.clear();
                sb.setLength(0);
            }
            else{
                sb.append(item);
            }
        }
        
        Collections.sort(list, (o1, o2) -> o1.size() - o2.size());
        for(int i=1;i<list.size();i++){
            for(Integer item: list.get(i)){
                if(!ans.contains(item)) ans.add(item);
            }
        }
        answer = new int[ans.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}