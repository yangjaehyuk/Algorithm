import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int person = 0;
        int th = 0;
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(list.size() == 0) list.add(words[i]);
            else{
                if(list.contains(words[i])){
                    int idx = i + 1;
                    int div = idx / n;
                    int mod = idx % n;
                    if(mod == 0){
                        person = n;
                        th = div;
                    }
                    else{
                        person = mod;
                        th = div + 1;
                    }
                    break;
                }
                else{
                    String thisStr = list.get(i-1);
                    String thisWord = words[i];
                    if(thisStr.charAt(thisStr.length()-1) != thisWord.charAt(0)){
                        System.out.println(thisStr+" "+thisWord);
                        int idx = i + 1;
                        int div = idx / n;
                        int mod = idx % n;
                        if(mod == 0){
                            person = n;
                            th = div;
                        }
                        else{
                            person = mod;
                            th = div + 1;
                        }
                        break;
                    }
                    else list.add(words[i]);
                }
            }
        }
        answer[0] = person;
        answer[1] = th;
        return answer;
    }
}