#include <iostream>

using namespace std;

int boss[300001];
int countPeople[300001];
int n;


int find(int n){
  if(boss[n]==0) return n;
  return boss[n]=find(boss[n]);
}

void setUnion(int t1, int t2){
  int a=find(t1);
  int b=find(t2);
  if(a==b) return;
  boss[b]=a;
  countPeople[a]+=countPeople[b];
  countPeople[b]=0;
}

int getCount(int n){
  int i=find(n);
  return countPeople[i];
}

int main(){
  for(int i=0;i<300001;i++){
    countPeople[i]=1;
  }
  cin>>n;
  for(int i=0;i<n-2;i++){
    int a,b;
    cin>>a>>b;
    setUnion(a,b);
  }
  for(int i=1;i<=n;i++){
    for(int j=1;j<=n;j++){
      if(i==j) continue;
      setUnion(i,j);
      if(getCount(i)==n){
        cout<<i<<" "<<j;
        return 0;
      }
    }
  }
}