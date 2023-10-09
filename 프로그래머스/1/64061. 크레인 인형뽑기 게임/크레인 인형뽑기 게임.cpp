#include <string>
#include <vector>
#include <iostream>
#include <stack>
using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    for(int i=0;i<moves.size();i++){
        moves[i]-=1;
    }
    stack<int> stack;
    int answer = 0;
    int col=board.size();
    for(int i=0;i<moves.size();i++){
        for(int j=0;j<col;j++){
            if(board[j][moves[i]]!=0){
                if(!stack.empty() && stack.top()==board[j][moves[i]]){
                  stack.pop();
                  answer+=2;
                }
                else{
                  stack.push(board[j][moves[i]]);
                }
                board[j][moves[i]]=0;
                break;
              }
                
            }
        }
  return answer;
}