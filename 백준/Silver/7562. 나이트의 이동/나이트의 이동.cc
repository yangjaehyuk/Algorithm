#include <iostream>
#include <queue>

int dx[8] = {-2,-1,1,2,2,1,-1,-2};
int dy[8] = {1,2,2,1,-1,-2,-2,-1};

using namespace std;

void bfs(int start, int end, int visited[301][301], int goalx, int goaly, int len, bool arr[301][301]){
  queue<pair<int, int>>q;
  q.push({start, end});
  visited[start][end]=1;
  arr[start][end]=true;
  while(!q.empty()){
    int front=q.front().first;
    int back=q.front().second;
    q.pop();
    // cout<<front<<" "<<back<<" "<<visited[front][back]<<endl;

    if(front==goalx && back==goaly){
      cout<<visited[front][back]-1<<endl;
      return ;
    }
    for(int i=0;i<8;i++){
      int nx=front+dx[i];
      int ny=back+dy[i];
      if(nx>=0 && ny>=0 && nx<len && ny<len && arr[nx][ny]==false  && visited[nx][ny]==0){
        visited[nx][ny]=visited[front][back]+1;
        q.push({nx,ny});
        arr[nx][ny]=true;
      }
    }

    

  }

}
int main(){
  int t;
  cin>>t;
  for(int i=0;i<t;i++){
    int visited[301][301];
    bool arr[301][301];
    int len;
    cin>>len;
    for(int i=0;i<len;i++){
      for(int j=0;j<len;j++){
        visited[i][j]=0;
      }
    }
    for(int i=0;i<len;i++){
      for(int j=0;j<len;j++){
        arr[i][j]=false;
      }
    }
    int px, py;
    cin>>px>>py;
    int gx,gy;
    cin>>gx>>gy;
    if(px==gx && py==gy){
      cout<<'0'<<endl;
      continue;
    }
    bfs(px, py, visited, gx, gy, len, arr);    
  }
  

}