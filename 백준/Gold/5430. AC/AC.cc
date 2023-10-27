#include <iostream>
#include <deque>
#include <string>
using namespace std;


int t;

int main(){
  ios_base::sync_with_stdio(false);
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin>>t;
  while(t--){
    bool zeroflag=true;
    bool flag=true;
    int turn=0;
    string tmp;
    string ans;
    deque<int> container;
    string str;
    cin>>str;
    int num;
    cin>>num;
    string p;
    cin>>p;
    string newP=p.substr(1,p.length()-2);
    newP+=',';

    if(newP.length()<=1){
      for(int i=0;i<str.length();i++){
        if(str[i]=='D'){
          zeroflag=false;
          cout<<"error"<<endl;
          break;
        }
        else{
          continue;
        }
      }
      if(zeroflag==true){
        newP+='[';
        newP+=']';
        newP.erase(0,1);
        cout<<newP<<endl;
      }
      
    }

    
    else{
      for(int i=0;i<newP.length();i++){
        if(newP[i]!=','){
          tmp+=newP[i];
        }
        else if(newP[i]==','){
          int tmpInt=stoi(tmp);
          container.push_back(tmpInt);
          tmp="";
        }
      }
      

      for(int i=0;i<str.length();i++){
        if(str[i]=='R'){
          // 돌리기
          turn++;
        }
        else{
          if(turn%2==0){
            if(container.size()>0){
              // container.erase(container.begin());
              container.pop_front();
            }
            else{
              if(container.size()<=0){
                flag=false;
                cout<<"error"<<endl;
                break;
              }
              
            }
          }
          else if(turn%2==1){
            // for(int j=0;j<container.size()/2;j++){
            //   swap(container[j], container[container.size()-j-1]);
            // }
            // for(int i=0;i<container.size();i++){
            //   cout<<container[i]<<" ";
            // }
            // cout<<endl;
            if(container.size()>0){
              container.pop_back();
            }
            else{
              if(container.size()<=0){
                flag=false;
                cout<<"error"<<endl;
                break;
              }
            }
          }
        }
      }
      
      if(flag==true){
        ans+='[';
        if(container.size()>0){
          if(turn%2==0){
            for(int i=0;i<container.size();i++){
              string tmp;
              tmp=to_string(container[i]);
              ans+=tmp;
              if(i==container.size()-1){
                ans+=']';
              }
              else{
                ans+=',';
              }
            }
          }
          else{
            for(int i=container.size()-1;i>=0;i--){
              string tmp;
              tmp=to_string(container[i]);
              ans+=tmp;
              if(i==0){
                ans+=']';
              }
              else{
                ans+=',';
              }
            }
          }
          
        }
        else ans+=']';
        cout<<ans<<endl;
      }
      
      
      // for(int i=0;i<container.size();i++){
      //   cout<<container[i]<<" ";
      // }
      // cout<<endl;
    }
  }
}