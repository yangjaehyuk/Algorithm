#include <iostream>
#include <queue>
using namespace std;

int dx[3]={2,1,-1};
queue<int> q;
int arr[200002]={0,};
int visited[200002]={0,};

int main(){
  bool flag=false;
  int n,k;
  cin>>n>>k;
  fill(arr,arr+200002,0);
  if(n==k){
    cout<<0<<endl;
    return 0;
  }
  q.push(n);
  arr[n]=0;
  visited[n]=1;

  while(!q.empty()){
    int front=q.front();
    q.pop();

    for(auto nx: {front+1, front-1, front*2}){
      if(nx==k){
        arr[nx]=arr[front]+1;
        cout<<arr[k];
        return 0;
      }
      if(nx>=0 && visited[nx]==0 && nx<=200000 && arr[nx]==0){
        arr[nx]=arr[front]+1;
        q.push(nx);
        visited[nx]=1;
      }
    }
  }


}