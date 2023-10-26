#include <iostream>
#include <set>
#include <algorithm>
using namespace std;

int main(){
  int t;
  cin>>t;
  while(t--){
    multiset<int> q;
    int k;
    cin>>k;
    for(int i=0;i<k;i++){
      char cal;
      int n;
      cin>>cal>>n;

      if(cal=='I'){
        q.insert(n);

      }
      else if(cal=='D'){
        if(q.empty()){
          continue;
        }
        if(n==1){ 
          // max delete
          
          auto end=q.end();
          end--;
          q.erase(end);
        }
        else{
          // min delete
          auto start=q.begin();
          q.erase(start);

        }
      }
    }
    if(q.size()==0) cout<<"EMPTY"<<endl;
    else{
      auto mini=q.begin();
      auto maxi=q.end();
      maxi--;
      cout<<*maxi<<" "<<*mini<<endl;
    }

  }

}