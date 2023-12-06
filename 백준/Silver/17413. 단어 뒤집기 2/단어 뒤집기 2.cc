#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  bool flag=false;
  string str;
  string tmp;
  string res;
  getline(cin, str);
  str+=' ';
  for(int i=0;i<str.length();i++){
    if(str[i]=='<'){
      if(tmp.length()>0){
        reverse(tmp.begin(), tmp.end());
        res+=tmp;
        flag=true;
        tmp=str[i];
      }
      else{
        flag=true;
        tmp+=str[i];
      }
    }
    else if(str[i]=='>' && flag==true){
      tmp+=str[i];
      res+=tmp;
      tmp="";
      flag=false;
    }
    else if(str[i]==' ' && flag==false){
      reverse(tmp.begin(), tmp.end());
      tmp+=str[i];
      res+=tmp;
      tmp="";
    }
    else if(flag==false){
      tmp+=str[i];
    }
    else if(flag==true){
      tmp+=str[i];
    }
  }
  cout<<res;
}