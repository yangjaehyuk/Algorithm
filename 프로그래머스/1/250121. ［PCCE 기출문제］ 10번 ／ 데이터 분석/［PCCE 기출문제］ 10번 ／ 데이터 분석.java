import java.util.*;
class Solution {
    // data에서 ext 값이 val_ext보다 작은 데이터만 뽑은 후, sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};
        ArrayList<int[]> list = new ArrayList<>();
        if(ext.equals("date")){
            for(int i=0;i<data.length;i++){
                if(val_ext>data[i][1]){
                    list.add(data[i]);
                }
            }
            if(sort_by.equals("code")){
                Collections.sort(list, (o1, o2)->{
                    return o1[0]-o2[0];
                });
            }
            else if(sort_by.equals("date")){
                Collections.sort(list, (o1, o2)->{
                    return o1[1]-o2[1];
                });
            }
            else if(sort_by.equals("maximum")){
                Collections.sort(list, (o1, o2)->{
                    return o1[2]-o2[2];
                });
            }
            else{
                Collections.sort(list, (o1, o2)->{
                    return o1[3]-o2[3];
                });
            }
        }
        else if(ext.equals("code")){
            for(int i=0;i<data.length;i++){
                if(val_ext>data[i][0]){
                    list.add(data[i]);
                }
            }
            if(sort_by.equals("code")){
                Collections.sort(list, (o1, o2)->{
                    return o1[0]-o2[0];
                });
            }
            else if(sort_by.equals("date")){
                Collections.sort(list, (o1, o2)->{
                    return o1[1]-o2[1];
                });
            }
            else if(sort_by.equals("maximum")){
                Collections.sort(list, (o1, o2)->{
                    return o1[2]-o2[2];
                });
            }
            else{
                Collections.sort(list, (o1, o2)->{
                    return o1[3]-o2[3];
                });
            }
        }
        else if(ext.equals("maximum")){
            for(int i=0;i<data.length;i++){
                if(val_ext>data[i][2]){
                    list.add(data[i]);
                }
            }
            if(sort_by.equals("code")){
                Collections.sort(list, (o1, o2)->{
                    return o1[0]-o2[0];
                });
            }
            else if(sort_by.equals("date")){
                Collections.sort(list, (o1, o2)->{
                    return o1[1]-o2[1];
                });
            }
            else if(sort_by.equals("maximum")){
                Collections.sort(list, (o1, o2)->{
                    return o1[2]-o2[2];
                });
            }
            else{
                Collections.sort(list, (o1, o2)->{
                    return o1[3]-o2[3];
                });
            }
        }
        else{
            for(int i=0;i<data.length;i++){
                if(val_ext>data[i][3]){
                    list.add(data[i]);
                }
            }
            if(sort_by.equals("code")){
                Collections.sort(list, (o1, o2)->{
                    return o1[0]-o2[0];
                });
            }
            else if(sort_by.equals("date")){
                Collections.sort(list, (o1, o2)->{
                    return o1[1]-o2[1];
                });
            }
            else if(sort_by.equals("maximum")){
                Collections.sort(list, (o1, o2)->{
                    return o1[2]-o2[2];
                });
            }
            else{
                Collections.sort(list, (o1, o2)->{
                    return o1[3]-o2[3];
                });
            }
        }
        answer = new int[list.size()][4];
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        return answer;
    }
}