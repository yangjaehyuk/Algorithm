#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> arr;
vector<pair<int,int>> ans;
int mini=2000000001;
int main(){
  int n;
  cin>>n;

  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    arr.push_back(num);
  }

  sort(arr.begin(), arr.end());

  int start=0;
  int end=n-1;

  while(start<end){

    int score=abs(arr[start]+arr[end]);
    if(mini>score){
      mini=score;
      ans.push_back({arr[start], arr[end]});
    }

    // start+1
    int score1=abs(arr[start+1]+arr[end]);
    // end-1
    int score2=abs(arr[start]+arr[end-1]);
    // start+1 && end-1

    if(start+2!=end){
      int score3=abs(arr[start+1]+arr[end-1]);
      int res=min({score1, score2, score3});
      if(res==score1) start++;
      else if(res==score2) end--;
      else{
        start++;
        end--;
      }
    }

    else{
      int res=min({score1, score2});
      if(res==score1) start++;
      else if(res==score2) end--;
    }


    
  }

  // for(pair<int,int> p:ans){
  //   cout<<p.first<<" "<<p.second<<endl;
  // }

  if(ans[ans.size()-1].first>ans[ans.size()-1].second){
    cout<<ans[ans.size()-1].second<<" "<<ans[ans.size()-1].first;
  }
  cout<<ans[ans.size()-1].first<<" "<<ans[ans.size()-1].second;


}