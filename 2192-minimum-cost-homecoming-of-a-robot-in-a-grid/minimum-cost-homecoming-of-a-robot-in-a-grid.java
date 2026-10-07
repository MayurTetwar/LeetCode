class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int ans=0;
        if(startPos[0]<homePos[0]){
            for(int i=startPos[0]+1;i<=homePos[0];i++){
                ans+=rowCosts[i];
            }
        }else{
            for(int i=startPos[0]-1;i>=homePos[0];i--){
                ans+=rowCosts[i];
            }
        }
        if(startPos[1]<homePos[1]){
            for(int i=startPos[1]+1;i<=homePos[1];i++){
                ans+=colCosts[i];
            }
        }else{
            for(int i=startPos[1]-1;i>=homePos[1];i--){
                ans+=colCosts[i];
            }
        }
        return ans;
    }
}