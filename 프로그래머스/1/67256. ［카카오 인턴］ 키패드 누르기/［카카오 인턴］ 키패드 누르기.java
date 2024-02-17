import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            list.add(numbers[i]);
        }
        int startL = 10;
        int startR = 12;
        for(int i=0;i<numbers.length;i++){
            if(list.get(i)==1 || list.get(i)==4 || list.get(i)==7){
                answer+='L';
                startL=list.get(i);
            }
            else if(list.get(i)==3 || list.get(i)==6 || list.get(i)==9){
                answer+='R';
                startR=list.get(i);
            }
            else {
                int lLen=Math.abs((startL-list.get(i))/3)+Math.abs((startL-list.get(i))%3);
                int rLen=Math.abs((startR-list.get(i))/3)+Math.abs((startR-list.get(i))%3);
                
                if(list.get(i)==0){
                    lLen = Math.abs((startL-11)/3)+Math.abs((startL-11)%3);
                    rLen = Math.abs((startR-11)/3)+Math.abs((startR-11)%3);
                    System.out.println(startL+" "+startR+" "+lLen+" "+rLen);
                    if(lLen>rLen){
                        answer+='R';
                        startR=11;
                    }
                    else if(lLen==rLen){
                        if(hand.equals("left")){
                            answer+='L';
                            startL=11;
                        }
                        else{
                            answer+='R';
                            startR=11;
                        }
                    }
                    else{
                        answer+='L';
                        startL=11;
                    }
                }
                else{
                    if(lLen>rLen){
                        answer+='R';
                        startR=list.get(i);
                    }
                    else if(lLen==rLen){
                        if(hand.equals("left")){
                            answer+='L';
                            startL=list.get(i);
                        }
                        else{
                            answer+='R';
                            startR=list.get(i);
                        }
                    }
                    else{
                        answer+='L';
                        startL=list.get(i);
                    }
                }
                
            }
            
        }
        return answer;
    }
}