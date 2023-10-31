#include <iostream>
#include <queue>
#include <vector>
using namespace std;

priority_queue<int, vector<int>, greater<int>> minq;
priority_queue<int> maxq;
vector<int> mid;
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  int n;
  cin>>n;

  for(int i=0;i<n;i++){
    int num;
    cin>>num;
    if(maxq.empty()){
      maxq.push(num);
    }
    else if(maxq.size()>minq.size()){
      minq.push(num);
    }
    else maxq.push(num);
    if(!minq.empty() && !maxq.empty()){
      if(maxq.top()>minq.top()){
        int maxtop=maxq.top();
        maxq.pop();
        int mintop=minq.top();
        minq.pop();

        maxq.push(mintop);
        minq.push(maxtop);
      }
    }
    cout<<maxq.top()<<'\n';
  }
}