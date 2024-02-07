import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        // 12345 -> 5
        // 21232425 -> 8
        // 3311224455 -> 10
        int[] answer = {};
        int[] firstTmp = {1,2,3,4,5};
        int[] secondTmp = {2,1,2,3,2,4,2,5};
        int[] thirdTmp = {3,3,1,1,2,2,4,4,5,5};
        List<Integer> tmp = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();
        List<Integer> third = new ArrayList<>();
        for(int i=0;i<10000/firstTmp.length;i++){
            for(int j=0;j<firstTmp.length;j++){
                first.add(firstTmp[j]);
            }
        }
        for(int i=0;i<10000/secondTmp.length;i++){
            for(int j=0;j<secondTmp.length;j++){
                second.add(secondTmp[j]);
            }
        }
        for(int i=0;i<10000/thirdTmp.length;i++){
            for(int j=0;j<thirdTmp.length;j++){
                third.add(thirdTmp[j]);
            }
        }
        int total1=0;
        int total2=0;
        int total3=0;
        for(int i=0;i<answers.length;i++){
            if(answers[i]==first.get(i)) total1++;
            if(answers[i]==second.get(i)) total2++;
            if(answers[i]==third.get(i)) total3++;
        }
        int maxi = Math.max(total1, total2);
        if(maxi<=total3) maxi=total3;
        
        if(total1==maxi) tmp.add(1);
        if(total2==maxi) tmp.add(2);
        if(total3==maxi) tmp.add(3);
        answer = new int[tmp.size()];
        for(int i=0;i<tmp.size();i++){
            answer[i]=tmp.get(i);
        }
        return answer;
    }
}