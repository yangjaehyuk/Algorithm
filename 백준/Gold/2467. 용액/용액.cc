#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> arr;
vector<pair<int, int>> container;
int mini=2000000001;
void bs(int start, int end){
  while(start<end){
    int ans=abs(arr[start]+arr[end]);
    mini=min(ans,mini);
    if(mini==ans){
      container.push_back({arr[start], arr[end]});
    }
    if(end-start>2){
      int num1=abs(arr[start+1]+arr[end]);
      int num2=abs(arr[start]+arr[end-1]);
      int num3=abs(arr[start+1]+arr[end-1]);
      int res=min({num1, num2, num3});
      if(res==num1){
        start++;
      }
      else if(res==num2){
        end--;
      }
      else if(res==num3){
        start++;
        end--;
      }
    }

    else{
      int num1=abs(arr[start+1]+arr[end]);
      int num2=abs(arr[start]+arr[end-1]);
      int res=min({num1, num2});
      if(res==num1){
        start++;
      }
      else if(res==num2){
        end--;
      }
    }
  }

}
int main(){
  int n;
  cin>>n;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    arr.push_back(num);
  }
  bs(0,n-1);
  cout<<container[container.size()-1].first<<" "<<container[container.size()-1].second<<endl;

}