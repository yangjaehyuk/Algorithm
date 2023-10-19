#include <iostream>

using namespace std;
int n,m;
int search,num1,num2;

int boss[1000001];

int find(int n){
  if(boss[n]==n) return n;
  return boss[n]=find(boss[n]);
}

void setUnion(int t1, int t2){
  int a=find(t1);
  int b=find(t2);
  if(a==b) return;
  boss[b]=a;
}
int main(){
  
  ios_base :: sync_with_stdio(false);
  cin.tie(NULL);
  cout.tie(NULL);
  cin>>n>>m;

  for(int i=1;i<n+1;i++){
    boss[i]=i;
  }

  for(int i=0;i<m;i++){
    cin>>search>>num1>>num2;
    if(search==0){
      setUnion(num1, num2);
    }
    else if(search==1){
      int r1=find(num1);
      int r2=find(num2);

      if(r1==r2) cout<<"YES"<<'\n';
      else cout<<"NO"<<'\n';
    }
    
  }
}