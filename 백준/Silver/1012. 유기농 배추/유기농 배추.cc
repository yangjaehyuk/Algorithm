#include <iostream>
#include <queue>
using namespace std;

int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int main(){
  int t;
  cin>>t;
  for(int z=0;z<t;z++){
    int cnt=0;
    int arr[51][51]={0};
    int m,n,k;
    cin>>m>>n>>k;
    for(int i=0;i<k;i++){
      int x,y;
      cin>>y>>x;
      arr[x][y]=1;
    }

    // for(int i=0;i<n;i++){
    //   for(int j=0;j<m;j++){
    //     cout<<arr[i][j]<<" ";
    //   }
    //   cout<<endl;
    // }
    
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        if(arr[i][j]==1){
          queue<pair<int,int>> q;
          if(arr[i][j]!=0){
            cnt++;
            q.push({i,j});
            arr[i][j]=0;
          }
          while(!q.empty()){
            int start=q.front().first;
            int end=q.front().second;
            q.pop();

            for(int w=0;w<4;w++){
              int nx=start+dx[w];
              int ny=end+dy[w];

              if(nx>=0 && ny>=0 && nx<n && ny<m && arr[nx][ny]==1){
                q.push({nx, ny});
                arr[nx][ny]=0;
              }
            }
          }
        }
      }
    }
    // for(int i=0;i<n;i++){
    //   for(int j=0;j<m;j++){
    //     cout<<arr[i][j]<<" ";
    //   }
    //   cout<<endl;
    // }
    cout<<cnt<<endl;
  }
}