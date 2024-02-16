import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R',0);
        map.put('T',0);
        map.put('C',0);
        map.put('F',0);
        map.put('J',0);
        map.put('M',0);
        map.put('A',0);
        map.put('N',0);
        String answer = "";
        for(int i=0;i<choices.length;i++){
            if(choices[i]==4) continue;
            else{
                if(choices[i]==1){
                    int val = map.get(survey[i].charAt(0));
                    map.put(survey[i].charAt(0), val+=3);
                }
                else if(choices[i]==2){
                    int val = map.get(survey[i].charAt(0));
                    map.put(survey[i].charAt(0), val+=2);
                }
                else if(choices[i]==3){
                    int val = map.get(survey[i].charAt(0));
                    map.put(survey[i].charAt(0), val+=1);
                }
                else if(choices[i]==5){
                    int val = map.get(survey[i].charAt(1));
                    map.put(survey[i].charAt(1), val+=1);
                }
                else if(choices[i]==6){
                    int val = map.get(survey[i].charAt(1));
                    map.put(survey[i].charAt(1), val+=2);
                }
                else if(choices[i]==7){
                    int val = map.get(survey[i].charAt(1));
                    map.put(survey[i].charAt(1), val+=3);
                }
            }
        }
        String[] arr = {"RT","CF","JM","AN"};
        for(int i=0;i<4;i++){
            char val1 = arr[i].charAt(0);
            char val2 = arr[i].charAt(1);
            int num1 = map.get(val1);
            int num2 = map.get(val2);
            if(num1>num2){
                answer+=val1;
            }
            else if(num1<num2){
                answer+=val2;
            }
            else{
                if((int)val1>(int)val2){
                    answer+=val2;
                }
                else answer+=val1;
            }
        }
        return answer;
    }
}