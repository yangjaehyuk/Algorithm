#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


int main(){
  int n;
  cin>>n;
  vector<long long>stack;
  vector<long long>copyStack;
  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    stack.push_back(num);
    copyStack.push_back(num);
  }

  sort(stack.begin(), stack.end());

  stack.erase(unique(stack.begin(), stack.end()),stack.end());

  for(int i=0;i<n;i++){
    cout<<lower_bound(stack.begin(),stack.end(),copyStack[i])-stack.begin()<<" ";
  }


  
}