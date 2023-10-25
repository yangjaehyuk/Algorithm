#include <iostream>
#include <vector>
using namespace std;


int arr[501][501];
vector<int> tmp;
int main(){
  int ans=0;
  int height, width;
  cin>>height>>width;
  for(int i=0;i<width;i++){
    int block;
    cin>>block;
    tmp.push_back(block);
  }

  for(int i=1;i<tmp.size()-1;i++){
    
    int maxiL=0;
    int maxiR=0;
    for(int j=0;j<i;j++){
      maxiL=max(maxiL, tmp[j]);
    }
    for(int j=i;j<tmp.size();j++){
      maxiR=max(maxiR, tmp[j]);
    }
    if(maxiL==0 || maxiR==0) continue;
    if(maxiL==tmp[i] || maxiR==tmp[i]) continue;
    if(maxiL>=maxiR && tmp[i]<maxiR){
      ans+=maxiR-tmp[i];
    }
    else if(maxiL<=maxiR && tmp[i]<maxiL) {
      ans+=maxiL-tmp[i];
    }
  }
  cout<<ans;
}