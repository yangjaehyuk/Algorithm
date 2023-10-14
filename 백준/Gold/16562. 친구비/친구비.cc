#include <iostream>
#include <algorithm>
using namespace std;

int sum=0;

int arr[10001];

int boss[10001];

int find(int n){
  if(boss[n]==0) return n;
  return boss[n]=find(boss[n]);
}

void setUnion(int t1, int t2){
  int a=find(t1);
  int b=find(t2);
  if(a==b) return;
  boss[b]=a;
}

int main(){
  int n,m,k;
  cin>>n>>m>>k;
  for(int i=1;i<=n;i++){
    cin>>arr[i];
  }

  for(int i=1;i<=m;i++){
    int a,b;
    cin>>a>>b;
    setUnion(a,b);

  }
  for (int i=1;i<=n;i++) {
    int tmp=21e8;
    if (find(i)==i) {
      for (int j=1;j<=n;j++) {
        if (find(j)==i) {
          if(arr[j]<tmp){
            tmp=arr[j];
          }
        }
      }
      sum+=tmp;
    }
  }
  if(k>=sum){
    cout<<sum;
  }
  else{
    cout<<"Oh no";
  }
}