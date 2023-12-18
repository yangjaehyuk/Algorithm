#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int r,c;
char arr[21][21];
vector<string> container;

int main(){
  cin>>r>>c;
  string str;
  for(int i=0;i<r;i++){
    cin>>str;
    for(int j=0;j<str.size();j++){
      arr[i][j]=str[j];
    }
  }
  for(int i=0;i<r;i++){
    string ans;

    for(int j=0;j<c;j++){
      if(arr[i][j]=='#'){
        if(ans.size()>1){
          container.push_back(ans);
          ans="";
        }
        else{
          ans="";
        }
      }
      else ans+=arr[i][j];
    }
    if(ans.size()>1) container.push_back(ans);
  }
  for(int i=0;i<c;i++){
    string ans;
    for(int j=0;j<r;j++){
      if(arr[j][i]=='#'){
        if(ans.size()>1){
          container.push_back(ans);
          ans="";
        }
        else{
          ans="";
        }
      }
      else ans+=arr[j][i];
    }
    if(ans.size()>1) container.push_back(ans);
  }

  sort(container.begin(), container.end());
  container.erase(unique(container.begin(), container.end()), container.end());
  cout<<container[0];
}