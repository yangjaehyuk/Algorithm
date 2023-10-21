#include<vector>
#include<queue>
#include<iostream>
using namespace std;

int dx[4]={0,0,1,-1};
int dy[4]={1,-1,0,0};
int visited[101][101]={0,};
int solution(vector<vector<int> > maps)
{
    int cnt=0;
    int answer = 0;
    int n=maps.size();
    int m=maps[0].size();
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(maps[i][j]==1 && visited[i][j]==0 && cnt==0){
                cnt++;
                queue<pair<int,int>> q;
                q.push({i,j});
                visited[i][j]=1;
                maps[i][j]
=1;                
                while(!q.empty()){
                    int front=q.front().first;
                    int back=q.front().second;
                    q.pop();
                    
                    for(int k=0;k<4;k++){
                        int nx=front+dx[k];
                        int ny=back+dy[k];
                        
                        if(nx>=0 && ny>=0 && nx<n && ny<m && visited[nx][ny]==0 && maps[nx][ny]==1){
                            q.push({nx,ny});
                            maps[nx][ny]=maps[front][back]+1;
                            visited[nx][ny]=1;
                        }
                    }
                }
            }
        }
    }
    
    
    if(visited[n-1][m-1]==1) return maps[n-1][m-1];
    else return -1;
}