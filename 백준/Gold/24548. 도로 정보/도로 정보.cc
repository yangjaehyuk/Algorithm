#include <iostream>
#include <string.h>
using namespace std;

int main(){
  // 나무 t, 잔디 g, 울타리 f, 사람 p
  // 흥미로운 구간이란 길이가 1 이상인 도로 중에서 그가 속한 모든 물체의 수가 3의 배수
  // ex) 나무 3개, 울타리 3개 -> 흥미로운 구간
  // ex) 나무 3개, 울타리 2개 -> 흥미롭지 않은 구간
  // 1중 포문으로
  int n;
  int cnt=0;
  cin>>n;
  string str;
  cin>>str;
  int t=0,g=0,f=0,p=0;
  int arr[3][3][3][3];
  memset(arr, 0, sizeof(arr));
  arr[0][0][0][0]=1;

  for(int i=0;i<n;i++){
    if(str[i]=='T'){
      t=(t+1)%3;
    }
    else if(str[i]=='G'){
      g=(g+1)%3;
    }
    else if(str[i]=='F'){
      f=(f+1)%3;
    }
    else{
      p=(p+1)%3;
    }
    // cout<<arr[0]<<" "<<arr[1]<<" "<<arr[2]<<" "<<arr[3]<<endl;
    cnt+=arr[t][g][f][p];
    arr[t][g][f][p]++;
  }
  cout<<cnt;
  
}