import java.util.*;
class Solution {
    // 배열에 x, y랑 nx, ny 넣기
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String dirs) {
        int answer = 0;
        Set<Pair> tmp = new HashSet<>();
        int x = 0;
        int y = 0;
        for(int i=0;i<dirs.length();i++){
            if(dirs.charAt(i) == 'U'){
                int nx = x + dx[0];
                int ny = y + dy[0];
                if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                    if(!tmp.contains(new Pair(x,y,nx,ny)) && !tmp.contains(new Pair(nx, ny, x, y))){
                        tmp.add(new Pair(x,y,nx,ny));
                        answer++;
                    }
                    x = nx;
                    y = ny;
                }
            }
            else if(dirs.charAt(i) == 'D'){
                int nx = x + dx[2];
                int ny = y + dy[2];
                if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                    if(!tmp.contains(new Pair(x,y,nx,ny)) && !tmp.contains(new Pair(nx, ny, x, y))){
                        tmp.add(new Pair(x,y,nx,ny));
                        answer++;
                    }
                    x = nx;
                    y = ny;
                }
            }
            else if(dirs.charAt(i) == 'R'){
                int nx = x + dx[1];
                int ny = y + dy[1];
                if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                    if(!tmp.contains(new Pair(x,y,nx,ny)) && !tmp.contains(new Pair(nx, ny, x, y))){
                        tmp.add(new Pair(x,y,nx,ny));
                        answer++;
                    }
                    x = nx;
                    y = ny;
                }
            }
            else if(dirs.charAt(i) == 'L'){
                int nx = x + dx[3];
                int ny = y + dy[3];
                if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                    if(!tmp.contains(new Pair(x,y,nx,ny)) && !tmp.contains(new Pair(nx, ny, x, y))){
                        tmp.add(new Pair(x,y,nx,ny));
                        answer++;
                    }
                    x = nx;
                    y = ny;
                }
            }
        }
        return answer;
    }
    
    public static class Pair{
        int x;
        int y;
        int nx;
        int ny;
        Pair(int x, int y, int nx, int ny){
            this.x = x;
            this.y = y;
            this.nx = nx;
            this.ny = ny;
        }
        
        @Override
        public boolean equals(Object o){
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y && nx == pair.nx && ny == pair.ny;
        }
        
        @Override
        public int hashCode(){
            return Objects.hash(x,y,nx,ny);
        }
    }
}