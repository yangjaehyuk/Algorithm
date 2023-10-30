#include <iostream>
#include <queue>
#include <vector>
using namespace std;



vector<priority_queue<int, vector<int>, greater<int>>> arr(12);

int n,k;
int sum=0;
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  cin>>n>>k;
  for(int i=0;i<n;i++){
    int pos, val;
    cin>>pos>>val;
    arr[pos].push(val*-1);
  }

  

  for(int i=0;i<k;i++){
    for(int j=1;j<12;j++){
      if(!arr[j].empty()){
        int tmp=(arr[j].top()*-1);
        arr[j].pop();
        if(tmp>0){
          arr[j].push((tmp-1)*-1);
        }
      }
    }
  }
  for(int i=1;i<12;i++){
    if(!arr[i].empty()){
      sum+=(arr[i].top())*-1;
      arr[i].pop();
    }
  }
  

  cout<<sum<<endl;

}