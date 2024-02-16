import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // 모든 달은 28일까지
        List<Integer> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<terms.length;i++){
            String first = Character.toString(terms[i].charAt(0));
            Integer second = Integer.parseInt(terms[i].substring(2));
            map.put(first, second);
        }
        for(int i=0;i<privacies.length;i++){
            int res = map.get(Character.toString(privacies[i].charAt(privacies[i].length()-1)));
            String day = privacies[i].substring(8,10);
            int thisDay = Integer.parseInt(day);
            thisDay-=1;
            
            String dayTmp = Integer.toString(thisDay);
            String month = privacies[i].substring(5,7);
            int thisMonth = Integer.parseInt(month);
            thisMonth+=res;
            String year = privacies[i].substring(0,4);
            int thisYear = Integer.parseInt(year);
            if(thisDay==0){
                thisDay=28;
                thisMonth--;
            }
            while(true){
                if(thisMonth<=12) break;
                if(thisMonth>12){
                    thisYear++;
                    thisMonth-=12;
                }
            }
            String monthTmp = Integer.toString(thisMonth);
            String yearTmp = Integer.toString(thisYear);
            if(thisYear<Integer.parseInt(today.substring(0,4))){
                list.add(i+1);
            }
            else{
                if(thisYear==Integer.parseInt(today.substring(0,4))){
                    if(thisMonth<Integer.parseInt(today.substring(5,7))){
                        list.add(i+1);
                    }
                    else if(thisMonth==Integer.parseInt(today.substring(5,7))){
                        if(thisDay<Integer.parseInt(today.substring(8,10))){
                            list.add(i+1);
                        }
                    }
                }
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}