#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;
vector<int> cntContainer;
int group;
int n;
int arr[26][26];
int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
void bfs(){
  int cnt=1;
  for(int i=0;i<n;i++){
    for(int j=0;j<n;j++){
      if(arr[i][j]==1){
        queue<pair<int, int>>q;
        q.push({i,j});
        while(!q.empty()){
          int start=q.front().first;
          int end=q.front().second;
          arr[start][end]=0;
          q.pop();

          for(int k=0;k<4;k++){
            int nx=start+dx[k];
            int ny=end+dy[k];
            if(arr[nx][ny]==1 && nx>=0 && nx<n && ny>=0 && ny<n){
              q.push({nx,ny});
              arr[nx][ny]=0;
              cnt++;
            }

          }
        }
        group++;
        cntContainer.push_back(cnt);
        cnt=1;
      }
    }
  }
  cout<<group<<endl;
  sort(cntContainer.begin(), cntContainer.end());
  for(int i=0;i<cntContainer.size();i++){
    cout<<cntContainer[i]<<endl;
  }
}
int main(){
  cin>>n;
  for(int i=0;i<n;i++){
    string str;
    cin>>str;
    for(int j=0;j<str.length();j++){
      arr[i][j]=str[j]-'0';
    }
  }

  bfs();
}