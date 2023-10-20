#include <iostream>

using namespace std;


long long dp[101];
int main(){
  int t;
  cin>>t;
  for(int i=0;i<t;i++){
    int n;
    cin>>n;

    dp[0]=1;
    dp[1]=1;
    dp[2]=1;

    for(int j=3;j<n;j++){
      dp[j]=dp[j-3]+dp[j-2];
    }
    cout<<dp[n-1]<<'\n';
  }
}