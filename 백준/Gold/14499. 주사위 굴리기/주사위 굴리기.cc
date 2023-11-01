#include <iostream>
#include <vector>
using namespace std;

vector<int> orderContainer;
int arr[21][21];
int dx[4]={0,0,-1,1};
int dy[4]={1,-1,0,0};
int dice[6]={0,};
int tmp[6]={0,};

int main(){
  int n,m,x,y,k;
  cin>>n>>m>>x>>y>>k;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cin>>arr[i][j];
    }
  }
  for(int i=0;i<k;i++){
    int order;
    cin>>order;
    orderContainer.push_back(order);
    // 1 동, 2 서, 3 북, 4 남
  }

  for(int i=0;i<orderContainer.size();i++){
    int nx=x+dx[orderContainer[i]-1];
    int ny=y+dy[orderContainer[i]-1];

    if(nx>=0 && ny>=0 && nx<n && ny<m){
      if(arr[nx][ny]==0){
        // 주사위 바닥면에 쓰여 있는 수가 칸에 복사
        if(orderContainer[i]-1==0){
          // 동
          // 주사위 굴리고
          // 바닥면 수를 arr[nx][ny]로
          tmp[0]=dice[3];
          tmp[1]=dice[1];
          tmp[2]=dice[0];
          tmp[3]=dice[5];
          tmp[4]=dice[4];
          tmp[5]=dice[2];
          arr[nx][ny]=tmp[5];
          for(int j=0;j<6;j++){
            dice[j]=tmp[j];
            tmp[j]=0;
          }
        }
        else if(orderContainer[i]-1==1){
          // 서
          tmp[0]=dice[2];
          tmp[1]=dice[1];
          tmp[2]=dice[5];
          tmp[3]=dice[0];
          tmp[4]=dice[4];
          tmp[5]=dice[3];
          arr[nx][ny]=tmp[5];
          for(int j=0;j<6;j++){
            dice[j]=tmp[j];
            tmp[j]=0;
          }
        }
        else if(orderContainer[i]-1==2){
          // 남
          tmp[0]=dice[4];
          tmp[1]=dice[0];
          tmp[2]=dice[2];
          tmp[3]=dice[3];
          tmp[4]=dice[5];
          tmp[5]=dice[1];
          arr[nx][ny]=tmp[5];
          for(int j=0;j<6;j++){
            dice[j]=tmp[j];
            tmp[j]=0;
          }
        }
        else{
          // 북
          tmp[0]=dice[1];
          tmp[1]=dice[5];
          tmp[2]=dice[2];
          tmp[3]=dice[3];
          tmp[4]=dice[0];
          tmp[5]=dice[4];
          arr[nx][ny]=tmp[5];
          for(int j=0;j<6;j++){
            dice[j]=tmp[j];
            tmp[j]=0;
          }
        }

      }
      else{
        // 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사
        // 칸에 쓰여 있는 수는 0
        if(orderContainer[i]-1==0){
          // 동
          // arr[nx][ny]를 dice의 바닥면으로
          // arr[nx][ny]를 0으로
          tmp[0]=dice[3];
          tmp[1]=dice[1];
          tmp[2]=dice[0];
          tmp[3]=dice[5];
          tmp[4]=dice[4];
          tmp[5]=dice[2];
          tmp[5]=arr[nx][ny];
          arr[nx][ny]=0;
          for(int j=0;j<6;j++){
            dice[j]=tmp[j];
            tmp[j]=0;
          }
        }
        else if(orderContainer[i]-1==1){
          // 서
          tmp[0]=dice[2];
          tmp[1]=dice[1];
          tmp[2]=dice[5];
          tmp[3]=dice[0];
          tmp[4]=dice[4];
          tmp[5]=dice[3];
          tmp[5]=arr[nx][ny];
          arr[nx][ny]=0;
          for(int j=0;j<6;j++){
            dice[j]=tmp[j];
            tmp[j]=0;
          }
        }
        else if(orderContainer[i]-1==2){
          // 남
          tmp[0]=dice[4];
          tmp[1]=dice[0];
          tmp[2]=dice[2];
          tmp[3]=dice[3];
          tmp[4]=dice[5];
          tmp[5]=dice[1];
          tmp[5]=arr[nx][ny];
          arr[nx][ny]=0;
          for(int j=0;j<6;j++){
            dice[j]=tmp[j];
            tmp[j]=0;
          }
        }
        else{
          // 북
          tmp[0]=dice[1];
          tmp[1]=dice[5];
          tmp[2]=dice[2];
          tmp[3]=dice[3];
          tmp[4]=dice[0];
          tmp[5]=dice[4];
          tmp[5]=arr[nx][ny];
          arr[nx][ny]=0;
          for(int j=0;j<6;j++){
            dice[j]=tmp[j];
            tmp[j]=0;
          }
        }
      }
      cout<<dice[0]<<endl;
      x=nx;
      y=ny;
    }
  }
  // for(int i=0;i<n;i++){
  //   for(int j=0;j<m;j++){
  //     cout<<arr[i][j]<<" ";
  //   }
  //   cout<<endl;
  // }
}
