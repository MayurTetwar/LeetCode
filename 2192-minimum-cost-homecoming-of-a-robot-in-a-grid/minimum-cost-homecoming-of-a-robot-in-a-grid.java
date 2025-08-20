class Solution {
    public int minCost(int[] st, int[] home, int[] row, int[] col) {
        int n=row.length;
        int m=col.length;
        int verticalSum=0;
        if(st[0]!=home[0]){
            if(st[0]<home[0]){
                for(int i=st[0]+1;i<=home[0];i++){
                    verticalSum+=row[i];
                }
            }else{
                for(int i=st[0]-1;i>=home[0];i--){
                    verticalSum+=row[i];
                }
            }
        }
        int horizontalSum=0;
        if(st[1]!=home[1]){
            if(st[1]<home[1]){
                for(int i=st[1]+1;i<=home[1];i++){
                    horizontalSum+=col[i];
                }
            }else{
                for(int i=st[1]-1;i>=home[1];i--){
                    horizontalSum+=col[i];
                }
            }
        }
       // System.out.println(horizontalSum+" "+verticalSum);
        return verticalSum+horizontalSum;
    }
}