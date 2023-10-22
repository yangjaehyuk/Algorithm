#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> container;
int boss[100001];
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

int line;
int node;
int main(){
  cin>>node>>line;
  for(int i=0;i<line;i++){
    int a,b;
    cin>>a>>b;
    setUnion(a,b);
  }

  for(int i=1;i<=node;i++){
    container.push_back(find(i));

  }
  sort(container.begin(), container.end());
  container.erase(unique(container.begin(), container.end()),container.end());
  cout<<container.size();
}