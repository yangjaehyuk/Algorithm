#include <iostream>
#include <queue>
struct Node{
  int x,y,z;
};
using namespace std;
int arr[1002][1002];
int visited[1002][1002][2];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int main(){
  cin.tie(nullptr);
  cout.tie(nullptr);
  int n,m;
  cin>>n>>m;
  for(int i=0;i<n;i++){
    string str;
    cin>>str;
    for(int j=0;j<str.length();j++){
      arr[i][j]=str[j]-'0';
    }
  }
  queue<Node> q;
  q.push({0,0,0});
  visited[0][0][0]=1;
  while(!q.empty()){
    int front=q.front().x;
    int back=q.front().y;
    int check=q.front().z;
    if(front==n-1 && back==m-1){
      cout<<visited[front][back][check]<<endl;
      return 0;
    }
    q.pop();
    for(int k=0;k<4;k++){
      int nx=front+dx[k];
      int ny=back+dy[k];
      if(nx>=0 && ny>=0 && nx<n && ny<m){
        if(arr[nx][ny]==0 && visited[nx][ny][check]==0){
          q.push({nx,ny,check});
          visited[nx][ny][check]=visited[front][back][check]+1;
        }
        else if(arr[nx][ny]==1 && check==0){
          q.push({nx,ny,check+1});
          visited[nx][ny][check+1]=visited[front][back][check]+1;
        }
      }
    }
  }
  cout<<-1;


}