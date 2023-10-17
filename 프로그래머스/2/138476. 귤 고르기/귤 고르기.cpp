#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;
int dat[10000001]={0};
int cnt=0;
int solution(int k, vector<int> tangerine) {
    for(int i=0;i<tangerine.size();i++){
        dat[tangerine[i]]++;
    }
    sort(dat,dat+10000001, greater<int>());
    
    int sum=0;
    for(int i=0;i<10000001;i++){
        if(sum>k){
            return cnt;
        }
        else if(sum==k){
            return cnt;
        }
        else{
            cnt++;
            sum+=dat[i];
        }
    }
    
}