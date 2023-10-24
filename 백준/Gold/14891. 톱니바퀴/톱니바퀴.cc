#include <iostream>

using namespace std;

int arr[4][8];

void left(int n){
  int tmp=arr[n-1][0];
  for(int j=0;j<7;j++){
    arr[n-1][j]=arr[n-1][j+1];
    }
  arr[n-1][7]=tmp;
}

void right(int n){
  int tmp=arr[n-1][7];
  for(int j=6;j>=0;j--){
    arr[n-1][j+1]=arr[n-1][j];
  }
  arr[n-1][0]=tmp;
}
int main(){
  for(int i=0;i<4;i++){
    string str;
    cin>>str;
    for(int j=0;j<8;j++){
      arr[i][j]=str[j]-'0';
    }
  }
  int k;
  cin>>k;
  for(int i=0;i<k;i++){
    int number, dir;
    cin>>number>>dir;

    

    if(dir==-1){
      // 반시계
      // 배열 왼쪽으로 1칸씩
      int firstClockSecond=arr[0][2];
      int secondClockSecond=arr[1][2];
      int secondClockSix=arr[1][6];
      int thirdClockSecond=arr[2][2];
      int thirdClockSix=arr[2][6];
      int fourthClockSix=arr[3][6];
      if(number==1){
        if(firstClockSecond != secondClockSix){
          if(secondClockSecond != thirdClockSix){
            if(thirdClockSecond != fourthClockSix){
              right(4);
            }
            left(3);
          }
          right(2);
        }
        left(1);
      }

      else if(number==2){
        if(firstClockSecond!=secondClockSix){
          right(1);
        }
        if(secondClockSecond != thirdClockSix){
          if(thirdClockSecond != fourthClockSix){
            left(4);
          }
          right(3);
        }
        left(2);
      }


      else if(number==3){
        if(thirdClockSecond!=fourthClockSix){
          right(4);
        }
        if(thirdClockSix!=secondClockSecond){
          if(secondClockSix!=firstClockSecond){
            left(1);
          }
          right(2);
        }
        left(3);
      }

    else if(number==4){
      if(fourthClockSix!=thirdClockSecond){
        if(thirdClockSix!=secondClockSecond){
          if(secondClockSix!=firstClockSecond){
            right(1);
          }
          left(2);
        }
        right(3);
      }
      left(4);
      }
    }

    else if(dir==1){
      // 시계
      // 배열 오른쪽으로 1칸씩
      int firstClockSecond=arr[0][2];
      int secondClockSecond=arr[1][2];
      int secondClockSix=arr[1][6];
      int thirdClockSecond=arr[2][2];
      int thirdClockSix=arr[2][6];
      int fourthClockSix=arr[3][6];
      if(number==1){
        if(firstClockSecond != secondClockSix){
          if(secondClockSecond != thirdClockSix){
            if(thirdClockSecond != fourthClockSix){
              left(4);
            }
            right(3);
          }
          left(2);
        }
        right(1);
      }

      else if(number==2){
        if(firstClockSecond!=secondClockSix){
          left(1);
        }
        if(secondClockSecond != thirdClockSix){
          if(thirdClockSecond != fourthClockSix){
            right(4);
          }
          left(3);
        }
        right(2);
      }


      else if(number==3){
        if(thirdClockSecond!=fourthClockSix){
          left(4);
        }
        if(thirdClockSix!=secondClockSecond){
          if(secondClockSix!=firstClockSecond){
            right(1);
          }
          left(2);
        }
        right(3);
      }

    else if(number==4){
      if(fourthClockSix!=thirdClockSecond){
        if(thirdClockSix!=secondClockSecond){
          if(secondClockSix!=firstClockSecond){
            left(1);
          }
          right(2);
        }
        left(3);
      }
      right(4);
      }

    }
  }
  
  int ans=0;
  int container[4]={1,2,4,8};
  for(int i=0;i<4;i++){
    if(arr[i][0]==1) ans+=container[i];
  }
  cout<<ans;
}