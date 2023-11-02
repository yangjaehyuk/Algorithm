#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> arr;
int sum=0;
int maxi=0;
int cnt=0;
int main(){
  int n,x;
  cin>>n>>x;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    arr.push_back(num);
  }

  for(int i=0;i<x;i++){
    sum+=arr[i];
  }

  for(int i=0;i<=n-x;i++){
    maxi=max(sum, maxi);
    if(i==n-x) break;
    sum+=arr[i+x];
    sum-=arr[i];
  }
  sum=0;
  for(int i=0;i<x;i++){
    sum+=arr[i];
  }

  for(int i=0;i<=n-x;i++){
    if(maxi==sum) cnt++;
    if(i==n-x) break;
    sum+=arr[i+x];
    sum-=arr[i];

  }
  if(maxi==0){
    cout<<"SAD";
    return 0;
  }
  else{
    cout<<maxi<<endl;
    cout<<cnt;

  }
}