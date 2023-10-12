#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int>arr[101];
bool visited[101];
int cnt=-1;
void dfs(int now){
  cnt++;

  visited[now]=true;
  for(int i=0;i<arr[now].size();i++){
    int next=arr[now][i];
    if(visited[next]==false){
      dfs(next);
      visited[next]=true;
    }
  }
};

int main(){
  int node, lines;
  cin>>node;
  cin>>lines;
  for(int i=0;i<lines;i++){
    int start, end;
    cin>>start>>end;
    arr[start].push_back(end);
    arr[end].push_back(start);
  }

  for(int i=0;i<node;i++){
    sort(arr[i].begin(), arr[i].end());
  }
  dfs(1);
  cout<<cnt;
}