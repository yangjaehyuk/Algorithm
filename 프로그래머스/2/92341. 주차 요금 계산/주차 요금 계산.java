import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        // 기본 시간
        int standardTime = fees[0];
        // 기본 비용
        int standardMoney = fees[1];
        // 단위 시간
        int criTime = fees[2];
        // 단위 요금
        int criMoney = fees[3];
        Set<Integer> carNum = new TreeSet<>();
        
        for(int i=0;i<records.length;i++){
            String carNumber = records[i].substring(6, 10);
            carNum.add(Integer.parseInt(carNumber));
        }
        answer = new int[carNum.size()];
        Iterator<Integer> iterCarNum = carNum.iterator();
        int index = 0;
        while(iterCarNum.hasNext()){
            Integer currentCarNum = iterCarNum.next();
            int time = -1;
            List<Integer> sum = new ArrayList<>();
            List<Integer> idx = new ArrayList<>();
            for(int j=0;j<records.length;j++){
                if(currentCarNum == Integer.parseInt(records[j].substring(6, 10))){
                    // 입차
                    if(records[j].charAt(11) == 'I'){
                        // 시간
                        time = Integer.parseInt(records[j].substring(0,2)) * 60 + Integer.parseInt(records[j].substring(3,5));
                        idx.add(j);
                    }
                    // 출차
                    else{
                        time = Integer.parseInt(records[j].substring(0,2)) * 60 + Integer.parseInt(records[j].substring(3,5)) - time;
                        sum.add(time);
                        time = -1;
                    }
                }
            }
            // 입차 기록만 있는 경우
            if(time > -1){
                int lastEntryTime = Integer.parseInt(records[idx.get(idx.size() - 1)].substring(0, 2)) * 60 + Integer.parseInt(records[idx.get(idx.size() - 1)].substring(3, 5));
                sum.add(1439 - lastEntryTime);
            }
            int tmp = 0;
            int money = 0;
            for(int k=0;k<sum.size();k++){
                tmp += sum.get(k);
            }
            // 기본 요금 적용
            money = standardMoney;

            // 초과 시간이 있는 경우 추가 요금 계산
            if (tmp > standardTime) {
                money += Math.ceil((double) (tmp - standardTime) / criTime) * criMoney;
            }
            answer[index++] = money;
        }
        return answer;
    }
}