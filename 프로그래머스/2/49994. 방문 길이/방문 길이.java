import java.util.*;
class Solution {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String dirs) {
        int answer = 0;
        int x=0;
        int y=0;
        Set<String> visited = new HashSet<>();
        for(int i=0;i<dirs.length();i++){
            if(dirs.charAt(i)=='U'){
                int nx = x + dx[0];
                int ny = y + dy[0];
                if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                    String tmp1 = x + "," + y + "," + nx + "," + ny;
                    String tmp2 = nx + "," + ny + "," + x + "," + y;
                    if(!visited.contains(tmp1) && !visited.contains(tmp2)) {
                        visited.add(tmp1);
                        visited.add(tmp2);
                        answer++;
                    }
                    x=nx;
                    y=ny;
                }
            }
            else if(dirs.charAt(i)=='D'){
                int nx = x + dx[2];
                int ny = y + dy[2];
                if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                    String tmp1 = x + "," + y + "," + nx + "," + ny;
                    String tmp2 = nx + "," + ny + "," + x + "," + y;
                    if(!visited.contains(tmp1) && !visited.contains(tmp2)) {
                        visited.add(tmp1);
                        visited.add(tmp2);
                        answer++;
                    }
                    x=nx;
                    y=ny;
                }
            }
            else if(dirs.charAt(i)=='R'){
                int nx = x + dx[1];
                int ny = y + dy[1];
                if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                    String tmp1 = x + "," + y + "," + nx + "," + ny;
                    String tmp2 = nx + "," + ny + "," + x + "," + y;
                    if(!visited.contains(tmp1) && !visited.contains(tmp2)) {
                        visited.add(tmp1);
                        visited.add(tmp2);
                        answer++;
                    }
                    x=nx;
                    y=ny;
                }
            }
            else {
                int nx = x + dx[3];
                int ny = y + dy[3];
                if(nx >= -5 && nx <= 5 && ny >= -5 && ny <= 5){
                    String tmp1 = x + "," + y + "," + nx + "," + ny;
                    String tmp2 = nx + "," + ny + "," + x + "," + y;
                    if(!visited.contains(tmp1) && !visited.contains(tmp2)) {
                        visited.add(tmp1);
                        visited.add(tmp2);
                        answer++;
                    }
                    x=nx;
                    y=ny;
                }
                
            }
        }
        return answer;
    }
}