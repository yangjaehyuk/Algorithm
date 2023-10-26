#include <iostream>
#include <queue>

using namespace std;

struct compare{
  bool operator()(int a, int b){
    if(abs(a)<abs(b)) return false;
    if(abs(a)>abs(b)) return true;
    if(abs(a)==abs(b) && a<b) return false;
    if(abs(a)==abs(b) && a>b) return true;
  }
};
priority_queue<int, vector<int>, compare> q;



int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  int n;
  cin>>n;

  for(int i=0;i<n;i++){
    int t;
    cin>>t;

    if(t==0){
      if(q.empty()){
        cout<<"0"<<endl;
      }
      else{
        cout<<q.top()<<endl;
        q.pop();
      }
    }
    else{
      q.push(t);
    }
  }
}