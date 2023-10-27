#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Node{
  long long x;
  long long y;
  long long z;
};
int n;
vector<Node> ans;
vector<long long> arr;
long long mini=3000000001;
void bs(){
  for(int i=0;i<n;i++){
    int start=i+1;
    int end=n-1;
    while(start<end){
      long long res=arr[i]+arr[start]+arr[end];
      mini=min(abs(res),mini);
      if(mini==abs(res)){
        ans.push_back({arr[i],arr[start],arr[end]});
      }
      if(res>=0){
        end--;
      }
      else{
        start++;
      }
      
  }
  }
  
}
int main(){
  cin>>n;

  for(int i=0;i<n;i++){
    long long num;
    cin>>num;
    arr.push_back(num);
  }
  sort(arr.begin(), arr.end());
  // for(int i=0;i<arr.size();i++){
  //   cout<<arr[i]<<" ";
  // }
  // cout<<endl;
  bs();
  cout<<ans[ans.size()-1].x<<" "<<ans[ans.size()-1].y<<" "<<ans[ans.size()-1].z;
}