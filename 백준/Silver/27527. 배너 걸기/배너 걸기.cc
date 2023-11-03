#include <iostream>
#include <map>
#include <vector>
#include <algorithm>
using namespace std;
int maxi=0;
vector<int> container;
map<int, int> arr;

int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  int n,m;
  cin>>n>>m;
  int count=0;

  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    container.push_back(num);
  }

  if((9*m)%10==0){
    count=9*m/10;
  }
  else{
    count=9*m/10+1;
  }
  
  for(int i=0;i<m;i++){
    arr[container[i]]+=1;
    if(arr[container[i]]>=count){
      cout<<"YES";
      return 0;
    }
  }

  for(int i=0;i<=n-m;i++){
    arr[container[i]]--;
    arr[container[i+m]]++;
    if(arr[container[i+m]]>=count){
      cout<<"YES";
      return 0;
    }
  }

  cout<<"NO";



}