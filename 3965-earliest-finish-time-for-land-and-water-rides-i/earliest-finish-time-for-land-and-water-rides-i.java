class Solution {
    public int earliestFinishTime(int[] lt, int[] ld, int[] wt, int[] wd) {
        int min=10000000;
        int n=lt.length;
        int m=wt.length;
        for(int i=0;i<n;i++){
            int time=lt[i]+ld[i];
            for(int j=0;j<m;j++){
                min=Math.min(min,Math.max(time,wt[j])+wd[j]);
            }
        }
        for(int i=0;i<m;i++){
            int time=wt[i]+wd[i];
            for(int j=0;j<n;j++){
                min=Math.min(min,Math.max(time,lt[j])+ld[j]);
            }
        }
        return min;
    }
}