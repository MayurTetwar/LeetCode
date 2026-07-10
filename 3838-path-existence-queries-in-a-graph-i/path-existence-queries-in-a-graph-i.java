class Solution {
    public boolean[] pathExistenceQueries(int n, int[] arr, int diff, int[][] que) {
        int[] cat=new int[n];
        boolean[] ans=new boolean[que.length];
        cat[0]=1;
        for(int i=1;i<n;i++){
            if(arr[i]-arr[i-1]<=diff){
                cat[i]=cat[i-1];
            }else{
                cat[i]=cat[i-1]+1;
            }
        }
        int i=0;
        for(int[] q:que){
            ans[i++]=((cat[q[0]]==cat[q[1]])?true:false);
        }
        return ans;
    }
}