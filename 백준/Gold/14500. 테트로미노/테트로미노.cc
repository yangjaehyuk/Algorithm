#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int arr[501][501];
int sum=0;
int main(){
  int n,m;
  cin>>n>>m;
  for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
      cin>>arr[i][j];
    }
  }

  // 가로 ㅡ
  for(int i=0;i<n;i++){
    for(int j=0;j<m-3;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i][j+3];
      sum=max(sum, value);
    }
  }

  // 세로 ㅣ
  for(int i=0;i<n-3;i++){
    for(int j=0;j<m;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+3][j];
      sum=max(sum, value);
    }
  }

  // 네모모양
  for(int i=0;i<n-1;i++){
    for(int j=0;j<m-1;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i+1][j+1];
      sum=max(sum, value);
    }
  }

  // ㅜ
  for(int i=0;i<n-1;i++){
    for(int j=0;j<m-2;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1];
      sum=max(sum, value);
    }
  }

  // ㅗ
  for(int i=1;i<n;i++){
    for(int j=0;j<m-2;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i-1][j+1];
      sum=max(sum, value);
    }
  }

  // ㅏ
  for(int i=0;i<n-2;i++){
    for(int j=0;j<m-1;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j+1];
      sum=max(sum, value);
    }
  }

  // ㅓ
  for(int i=0;i<n-2;i++){
    for(int j=1;j<m;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j-1];
      sum=max(sum, value);
    }
  }

  // L
  for(int i=0;i<n-2;i++){
    for(int j=0;j<m-1;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j+1];
      sum=max(sum, value);
    }
  }

  // ㄴ
  for(int i=0;i<n-1;i++){
    for(int j=0;j<m-2;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2];
      sum=max(sum, value);
    }
  }

  // ㅢ
  for(int i=1;i<n;i++){
    for(int j=0;j<m-2;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i-1][j+2];
      sum=max(sum, value);
    }
  }

  // ㅢ L뒤집음
  for(int i=2;i<n;i++){
    for(int j=0;j<m-1;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i-2][j+1];
      sum=max(sum, value);
    }
  }

  for(int i=0;i<n-1;i++){
    for(int j=0;j<m-2;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i][j+2];
      sum=max(sum, value);
    }
  }

  for(int i=0;i<n-2;i++){
    for(int j=0;j<m-1;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+2][j+1];
      sum=max(sum, value);
    }
  }

  for(int i=0;i<n-1;i++){
    for(int j=0;j<m-2;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+2];
      // cout<<value<<endl;
      
      sum=max(sum, value);
    }
  }

  for(int i=0;i<n-2;i++){
    for(int j=0;j<m-1;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i+1][j]+arr[i+2][j];
      sum=max(sum, value);
    }
  }

  // 
  for(int i=0;i<n-2;i++){
    for(int j=0;j<m-1;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+2][j+1];
      sum=max(sum, value);
    }
  }

  for(int i=0;i<n-2;i++){
    for(int j=1;j<m;j++){
      int value=arr[i][j]+arr[i+1][j]+arr[i+1][j-1]+arr[i+2][j-1];
      
      sum=max(sum, value);
    }
  }

  for(int i=1;i<n;i++){
    for(int j=0;j<m-2;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i-1][j+1]+arr[i-1][j+2];
      sum=max(sum, value);
    }
  }

  for(int i=0;i<n-1;i++){
    for(int j=0;j<m-2;j++){
      int value=arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2];
      
      sum=max(sum, value);
    }
  }


  cout<<sum;

}