#include <iostream>

using namespace std;
int check1(string str){
  for(int i=0;i<str.length();i++){
    if(str[i]=='a' || str[i]=='e' || str[i]=='o' || str[i]=='i' || str[i]=='u'){
      return 1;
    }
  }
  return 0;
}
int check2(string str){
  if(str.length()>=3){
    for(int i=0;i<str.length()-2;i++){
      if((str[i]=='a' || str[i]=='e' || str[i]=='o' || str[i]=='i' || str[i]=='u') && (str[i+1]=='a' || str[i+1]=='e' || str[i+1]=='o' || str[i+1]=='i' || str[i+1]=='u') && (str[i+2]=='a' || str[i+2]=='e' || str[i+2]=='o' || str[i+2]=='i' || str[i+2]=='u')){
        return 0;
      }
      if(!(str[i]=='a' || str[i]=='e' || str[i]=='o' || str[i]=='i' || str[i]=='u') && !(str[i+1]=='a' || str[i+1]=='e' || str[i+1]=='o' || str[i+1]=='i' || str[i+1]=='u') && !(str[i+2]=='a' || str[i+2]=='e' || str[i+2]=='o' || str[i+2]=='i' || str[i+2]=='u')){
        return 0;
      }
    }
  }
  return 1;
}
int check3(string str){
  if(str.length()>=2){
    for(int i=0;i<str.length()-1;i++){
      if(str[i]==str[i+1] && (str[i]=='e' || str[i]=='o')){
        return 1;
      }
      else if(str[i]==str[i+1]){
        return 0;
      }
    }
  }
  
  return 1;
}
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  while(1){
    string str;
    cin>>str;
    if(str=="end") break;
    int c1=check1(str);
    int c2=check2(str);
    int c3=check3(str);
    if(c1==c2==c3 && c1==true){
      cout<<'<'<<str<<"> is acceptable."<<'\n';
    }
    else{
      cout<<'<'<<str<<"> is not acceptable."<<'\n';
    }
  }
}