#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

int main(){
  stack<int> stack;
  int n;
  cin>>n;
  int cnt=1;
  while(n--){
    int t;
    cin>>t;

    if(t==cnt) cnt++;
    else stack.push(t);

    while(!stack.empty() && stack.top()==cnt){
      stack.pop();
      cnt++;
    }
  }

  if(!stack.empty()) cout<<"Sad";
  else cout<<"Nice";
}