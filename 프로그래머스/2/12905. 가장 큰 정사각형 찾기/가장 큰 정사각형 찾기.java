class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1;
        int m = board.length;
        int n = board[0].length;
        int [][]nboard = new int[m+1][n+1];
        boolean check = true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 1){
                    check = false;
                    break;
                }
            }
        }
        if(check){
            return 0;
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                nboard[i][j] = board[i][j];
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(nboard[i][j] == 1){
                    nboard[i][j] = Math.min(nboard[i-1][j-1], Math.min(nboard[i-1][j], nboard[i][j-1])) + 1;
                }
                answer = Math.max(answer, nboard[i][j]);
            }
        }

        return answer * answer;
    }
}