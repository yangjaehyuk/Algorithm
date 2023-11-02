#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> arr;
int sum=0;
int mini=21e8;
int main(){
  int n,k;
  cin>>n>>k;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    if(num==1) arr.push_back(i);
  }

  if(arr.size()<k){
    cout<<"-1";
    return 0;
  }
  else{
    
    for(int i=0;i<=arr.size()-k;i++){
      sum+=arr[i+k-1];
      sum-=arr[i];
      mini=min(mini, sum);
      sum=0;
    }
    if(mini!=21e8) cout<<mini+1;
    else cout<<-1;
  }

}
