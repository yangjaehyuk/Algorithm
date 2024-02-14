class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,1,-1};
        // 북 남 동 서
        int sx = 0;
        int sy = 0;
        int rx = 0;
        int ry = 0;
        for(int i=0;i<park.length;i++){
            for(int j=0;j<park[i].length();j++){
                if(park[i].charAt(j)=='S'){
                    sx=i;
                    sy=j;
                    rx=i;
                    ry=j;
                    break;
                }
            }
        }
        for(String route: routes){
            boolean check = true;
            char dir = route.charAt(0);
            int dis = (int)(route.charAt(2))-48;
            int idx=0;
            if(dir=='N') idx=0;
            else if(dir=='S') idx=1;
            else if(dir=='W') idx=3;
            else if(dir=='E') idx=2;
            for(int i=0;i<dis;i++){
                int nx = sx+dx[idx];
                int ny = sy+dy[idx];
                if(nx>=0 && nx<park.length && ny>=0 && ny<park[0].length()){
                    System.out.println(park[nx].charAt(ny)+" "+nx+" "+ny);
                    if(park[nx].charAt(ny)=='X'){
                        check=false;
                        sx=rx;
                        sy=ry;
                        break;
                    }
                    else{
                        sx=nx;
                        sy=ny;
                    }
                }
                else{
                    check=false;
                    sx=rx;
                    sy=ry;
                    break;
                }
            }
            if(check==true){
                for(int i=0;i<dis;i++){
                    rx+=dx[idx];
                    ry+=dy[idx];
                }
            }
        }
        answer[0]=rx;
        answer[1]=ry;
        return answer;
    }
}