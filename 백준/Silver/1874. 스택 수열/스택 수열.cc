#include <iostream>
#include <vector>
using namespace std;

int maxi=0;
vector<char> arr;
vector<int> container;
vector<int> stack;
int main(){
  cout.tie(nullptr);
  cin.tie(nullptr);
  int n;
  int j=0;
  int cnt=1;
  cin>>n;
  bool flag=true;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    container.push_back(num);
    
    while(cnt<=num){
      stack.push_back(cnt);
      arr.push_back('+');
      cnt++;
    }
    if(stack[stack.size()-1]==container[j]){
      arr.push_back('-');
      int a=stack[stack.size()-1];
      maxi=max(maxi,a);
      stack.pop_back();
      j++;
    }
    else{
      flag=false;
    }
  }
  
    
  if(flag){
    for(int i=0;i<arr.size();i++){
      cout<<arr[i]<<'\n';
    }
  }
  else cout<<"NO";
}