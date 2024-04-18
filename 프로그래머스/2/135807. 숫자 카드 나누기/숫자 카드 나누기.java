import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        int maxA = Arrays.stream(arrayA).max().getAsInt();
        int maxB = Arrays.stream(arrayB).max().getAsInt();
        int finalMax = Math.max(maxA, maxB);
        int div = 2;
        while(true){
            if(div > finalMax) break;
            boolean check1 = true;
            boolean check2 = true;
            for(int i=0;i<arrayA.length;i++){
                if(arrayA[i] % div != 0){
                    check1 = false;
                    break;
                }
            }
            for(int j=0;j<arrayB.length;j++){
                if(arrayB[j] % div != 0){
                    check2 = false;
                    break;
                }
            }
            if(check1){
                list1.add(div);
            }
            if(check2){
                list2.add(div);
            }
            div++;
        }
        Collections.sort(list1);
        Collections.sort(list2);
        for(Integer item: list1){
            System.out.println("this is l1"+" "+item);
        }
        for(Integer item: list2){
            System.out.println("this is l2"+" "+item);
        }
        for(int i=0;i<list1.size();i++){
            boolean checkL1 = false;
            for(int j=0;j<arrayB.length;j++){
                if(arrayB[j] % list1.get(i) == 0){
                    checkL1 = true;
                    break;
                }
            }
            if(checkL1 == false) ans.add(list1.get(i)); 
        }
        for(int i=0;i<list2.size();i++){
            boolean checkL2 = false;
            for(int j=0;j<arrayA.length;j++){
                if(arrayA[j] % list2.get(i) == 0){
                    checkL2 = true;
                    break;
                }
            }
            if(checkL2 == false) ans.add(list2.get(i));
        }
        Collections.sort(ans);
        for(int i=0;i<ans.size();i++){
            System.out.println("this is ans "+ans.get(i));
        }
        if(ans.size() == 0) return 0;
        else{
            return ans.get(ans.size()-1);
        }
    }
}