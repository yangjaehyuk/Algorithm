import java.util.*;
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int full = health;
        int answer = 0;
        int maxi = 0;
        for(int i=0;i<attacks.length;i++){
            if(maxi<attacks[i][0]){
                maxi=attacks[i][0];
            }
        }
        int attack = 0;
        int j = 0;
        for(int i=0;i<=maxi;i++){
            while(true){
                System.out.print(attacks[j][0]+" "+i+" ");
                if(attacks[j][0]==i){
                    attack=0;
                    health-=attacks[j][1];
                    if(health<0) return -1;
                    System.out.println("걸림 "+health+" "+attack);
                    j++;
                    break;
                }
                else{
                    if(health==full){
                        System.out.println("만땅 "+health+" "+attack);
                        attack++;
                        break;
                    }
                    else{
                        if(attack!=bandage[0]){
                            attack++;
                            if(attack==bandage[0]){
                                attack=0;
                                health+=bandage[1]+bandage[2];
                                if(health>full) health=full;
                                System.out.println("연속 공격 성공 "+ health +" "+attack);
                                break;
                            }
                            else{
                                health+=bandage[1];
                                if(health>full) health=full;
                                System.out.println(health+" "+attack);
                            }
                            break;
                        }
                        }
                    }
            
                }
        }
        if(health<=0) health=-1;
        return health;
    }
}