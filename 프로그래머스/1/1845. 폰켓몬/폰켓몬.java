import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int[] arr = new int[set.size()];
        int idx=0;
        for(int num: set){
            arr[idx++]=num;
        }
        int len = arr.length;
        if(len>n/2) answer=n/2;
        else if(len<=n/2) answer=len;
        return answer;
    }
}