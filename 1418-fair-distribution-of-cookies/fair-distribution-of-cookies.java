class Solution {
    int ans;
    public int distributeCookies(int[] arr, int k) {
        ans=Integer.MAX_VALUE;
        helper(arr,new int[k],0);
        return ans;
    }
    public void helper(int[] arr,int[] arrk,int j){
        if(j==arr.length){
            int max=0;
            for(int i=0;i<arrk.length;i++){
                max=Math.max(max,arrk[i]);
            }
            ans=Math.min(ans,max);
            return ;
        }
        for(int i=0;i<arrk.length;i++){
            arrk[i]+=arr[j];
            helper(arr,arrk,j+1);
            arrk[i]-=arr[j];
        }
    }
}