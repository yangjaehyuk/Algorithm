#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<string> stack;

bool compare(string i, string j){
  if(i.length()<j.length()){
    return true;
  }
  else if(i.length()==j.length()){
    if(i<j){
      return true;
    }
  }
  return false;
}
int n;
int main(){
  cin>>n;
  for(int i=0;i<n;i++){
    string str;
    cin>>str;
    stack.push_back(str);
  }
  sort(stack.begin(), stack.end(), compare);
  stack.erase(unique(stack.begin(), stack.end()), stack.end());
  for(int i=0;i<stack.size();i++){
    cout<<stack[i]<<endl;
  }
}