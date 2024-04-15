import java.util.*;
class Solution
{
    public int cri = 0;
    public int solution(int [][]board)
    {
        if(board.length<2 || board[0].length<2) return 1;
        int[][] nBoard = new int[board.length+1][board[0].length+1];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                nBoard[i+1][j+1] = board[i][j];
            }
        }
        for(int i=1;i<nBoard.length;i++){
            for(int j=1;j<nBoard[0].length;j++){
                if(nBoard[i][j]==1){
                    nBoard[i][j] = Math.min(Math.min(nBoard[i-1][j], nBoard[i-1][j-1]), nBoard[i][j-1]) + 1;
                    if(cri<nBoard[i][j]) cri = nBoard[i][j];
                }
            }
        }
        return cri * cri;
    }
}