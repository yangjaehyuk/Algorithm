import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        List<List<Integer>> list = new ArrayList<>();
        s = s.substring(2, s.length() - 2);
        String[] sets = s.split("},\\{");
        for (String set : sets) {
            List<Integer> resultSet = new ArrayList<>();
            String[] numbers = set.split(",");
            for (String num : numbers) {
                resultSet.add(Integer.parseInt(num));
            }
            list.add(resultSet);
        }
        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> a, List<Integer> b){
                return a.size() - b.size();
            }
        });
        answer = new int[list.size()];
        Set<Integer> ansSet = new LinkedHashSet<>(); 
        for(int i=0; i<list.size(); i++){
            for(int j=0; j<list.get(i).size(); j++){
                ansSet.add(list.get(i).get(j)); 
            }
        }
        answer = new int[ansSet.size()];
        int index = 0;
        for(Integer num : ansSet){
            answer[index++] = num;
        }
        return answer;
    }
}