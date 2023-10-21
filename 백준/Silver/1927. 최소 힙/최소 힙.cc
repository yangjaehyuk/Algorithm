#include <iostream>
#include <queue>
using namespace std;


priority_queue<int, vector<int>, greater<int>> q;
int main(){

  cin.tie(nullptr);
  cout.tie(nullptr);
  int n;
  cin>>n;

  for(int i=0;i<n;i++){
    int num;
    cin>>num;

    if(num!=0){
      q.push(num);
    }

    else{

      if(q.empty()){
        cout<<'0'<<'\n';
      }

      else{
        cout<<q.top()<<'\n';
        q.pop();
      }
    }
  }
}