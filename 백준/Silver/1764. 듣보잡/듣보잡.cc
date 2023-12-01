#include <iostream>
#include <vector>
#include <set>
using namespace std;

vector<string> res;
set<string> lis;
set<string> s;
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  int n,m;
  cin>>n>>m;
  for(int i=0;i<n;i++){
    string listen;
    cin>>listen;
    lis.insert(listen);
  }
  for(int i=0;i<m;i++){
    string see;
    cin>>see;
    s.insert(see);
  }

  for(auto i:lis){
    if(s.find(i)!=s.end()){
      res.push_back(i);
    }
  }


  cout<<res.size()<<'\n';
  for(int i=0;i<res.size();i++){
    cout<<res[i]<<'\n';
  }
}