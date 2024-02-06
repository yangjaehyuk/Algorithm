import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        List<Integer> list = new ArrayList<>();
        int[] answer = new int[photo.length];
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        for(String[] arr: photo){
            int total=0;
            for(int j=0;j<arr.length;j++){
                if(map.containsKey(arr[j])){
                    total+=map.get(arr[j]);
                }
            }
            list.add(total);
        }
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}