#include <iostream>
#include <deque>
using namespace std;
deque<char> arr;

int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  string str1, str2;

  while(cin>>str1>>str2){
    
    for(int i=0;i<str1.length();i++){
      arr.push_back(str1[i]);
    }
    for(int i=0;i<str2.length();i++){
      if(str2[i]==arr[0]){
        arr.pop_front();
      }
    }
    if(arr.size()==0){
      cout<<"Yes"<<'\n';
      arr.clear();
    }
    else{
      cout<<"No"<<'\n';
      arr.clear();
    }
  }
}