#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<char> stack1;
vector<char> stack2;
int cnt=0;
int main(){
  int n;
  cin>>n;
  for(int i=0;i<n;i++){
    string str;
    cin>>str;
    for(int j=0;j<str.size();j++){
      if(stack1.size()==0){
        stack1.push_back(str[j]);
        stack2.push_back(str[j]);
      }
      else{
        if(stack1[stack1.size()-1]==str[j]) continue;
        else{
          stack1.push_back(str[j]);
          stack2.push_back(str[j]);
        }
      }
    }
    sort(stack2.begin(), stack2.end());
    stack2.erase(unique(stack2.begin(), stack2.end()), stack2.end());
    if(stack1.size()==stack2.size()) cnt++;
    stack1.clear();
    stack2.clear();
  }
  cout<<cnt;
}