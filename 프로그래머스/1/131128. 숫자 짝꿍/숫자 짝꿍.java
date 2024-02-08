import java.util.*;
class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        List<Character> list = new ArrayList<>();
        char[] arr1 = X.toCharArray();
        char[] arr2 = Y.toCharArray();
        boolean[] arr1Visited = new boolean[X.length()];
        boolean[] arr2Visited = new boolean[Y.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<10;i++){
            map.put(Integer.toString(i).charAt(0),0);
        }
        for(Character item: arr1){
            if(map.containsKey(item)){
                int value = map.get(item);
                map.put(item, ++value);
            }
        }
        for(Character item: arr2){
            if(map.containsKey(item)){
                if(map.get(item)>0){
                    list.add(item);
                    int value = map.get(item);
                    map.put(item, --value);
                }
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        for(Character item:list){
            answer.append(item);
        }
        if(answer.length()==0) return "-1";
        else if(answer.charAt(0)=='0') return "0";
        else return answer.toString();
    }
}