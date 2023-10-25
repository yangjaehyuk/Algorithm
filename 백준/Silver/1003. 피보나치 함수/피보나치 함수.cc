#include <iostream>
#include <string>
#include <vector>
using namespace std;
vector<pair<int,int>> arr;
int dp[41];
void fibo(int num){
  for(int i=2;i<=num;i++){
    dp[i]=dp[i-1]+dp[i-2];
  }
  arr.push_back({dp[num-1], dp[num]});
  return;
}
int main(){
  int n;
  cin>>n;
  dp[0]=0;
  dp[1]=1;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    if(num==0) cout<<1<<" "<<0<<endl;
    else if(num==1) cout<<0<<" "<<1<<endl;
    else{
      fibo(num);
      cout<<arr.front().first<<" "<<arr.front().second<<endl;
      arr.clear();
    }
  }
}