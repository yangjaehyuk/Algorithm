import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        Collections.sort(list);
        int tmpV = 1;
        for(int i=0;i<list.size()-1;i++){
            
            if(i == 0){
                int second = list.get(i);
                int first = list.get(i+1);
                int r = 0;
                while(second != 0){
                    r = first % second;
                    first = second;
                    second = r;
                }
                tmpV *= (list.get(i) * list.get(i+1)) / first;
            }
            else{
                int second = tmpV;
                int first = list.get(i+1);
                int r = 0;
                while(second != 0){
                    r = first % second;
                    first = second;
                    second = r;
                }
                tmpV *= list.get(i+1) / first;
            }
        }
        answer = tmpV;
        return answer;
    }
}