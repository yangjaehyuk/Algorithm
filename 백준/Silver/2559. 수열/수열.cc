#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> arr;
int maxi=-1000;
int main(){
  int n,k;
  cin>>n>>k;
  int sum=0;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    arr.push_back(num);
  }
  for(int i=0;i<k;i++){
    sum+=arr[i];
  }
  for(int i=0;i<=n-k;i++){
    maxi=max(maxi, sum);
    if(i==n-k) break;
    sum+=arr[i+k];
    sum-=arr[i];
  }
  cout<<maxi;
}