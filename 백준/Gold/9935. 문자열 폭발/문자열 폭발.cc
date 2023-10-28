#include <iostream>
#include <deque>

using namespace std;

int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  deque<char> deq;
  string str;
  cin>>str;
  string tar;
  cin>>tar;
  int l=0;
  for(int i=0;i<str.size();i++){
    deq.push_back(str[i]);
    l++;

    if(l>=tar.length()){
      bool found=true;
      for(int j=0;j<tar.size();j++){
        if(deq[l-tar.size()+j]!=tar[j]){
          found=false;
          break;
        }
      }
      if(found==true){
        for(int j=0;j<tar.size();j++){
          deq.pop_back();
          l--;
        }
      }
    }
  }
  if(deq.size()==0) cout<<"FRULA";
  else{
    for(int i=0;i<deq.size();i++){
      cout<<deq[i];
    }
  }
  
}