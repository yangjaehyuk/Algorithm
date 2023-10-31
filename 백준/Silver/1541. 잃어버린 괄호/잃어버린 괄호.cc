#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(){

  string str,tmp;
  bool flag=true;
  cin>>str;
  str+='+';
  int sum=0;
  for(int i=0;i<str.length();i++){
    if(str[i]!='+' && str[i]!='-'){
      tmp+=str[i];
    }
    else if(str[i]=='-'){
      if(flag==true){
        sum+=stoi(tmp);
        tmp.clear();
        flag=false;
      }
      else{
        sum-=stoi(tmp);
        tmp.clear();
      }
    }
    else if(str[i]=='+'){
      if(flag==false){
        // 빼기
        int inte=stoi(tmp);
        sum-=inte;
        tmp.clear();
      }
      else{
        // 더하기
        int inte=stoi(tmp);
        sum+=inte;
        tmp.clear();
      }
    }
  }


  // for(int i=0;i<arr.size();i++){
  //   cout<<arr[i]<<endl;
  // }
  cout<<sum;
}