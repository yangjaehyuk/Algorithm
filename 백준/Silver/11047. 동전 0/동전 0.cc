#include <iostream>
#include <vector>
using namespace std;

vector<int> arr;
int sum=0;
int cnt=0;
int main(){
  int n, coin;
  cin>>n>>coin;
  sum=coin;
  for(int i=0;i<n;i++){
    int money;
    cin>>money;
    arr.push_back(money);
  }
  while(true){
    if(sum==0) break;
    else{
      for(int i=arr.size()-1;i>=0;i--){
        if(arr[i]<=sum){
          sum-=arr[i];
          cnt++;
          break;
        }
      }
    }
  }
  cout<<cnt;
}