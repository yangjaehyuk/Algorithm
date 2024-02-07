import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<moves.length;i++){
            moves[i]--;
        }
        for(int move: moves){
            for(int i=0;i<board[move].length;i++){
                if(board[i][move]!=0){
                    if(stack.empty()){
                        stack.push(board[i][move]);
                        board[i][move]=0;
                        break;
                    }
                    else{
                        if(board[i][move]==stack.peek()){
                            stack.pop();
                            board[i][move]=0;
                            answer+=2;
                            break;
                        }
                        else{
                            stack.push(board[i][move]);
                            board[i][move]=0;
                            break;
                        }
                    }
                }
            }
        }
        return answer;
    }
}