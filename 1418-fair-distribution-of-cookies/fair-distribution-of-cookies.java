class Solution {
    int ans;
    public int distributeCookies(int[] arr, int k) {
        ans=Integer.MAX_VALUE;
        helper(arr,new int[k],0,0);
        return ans;
    }
    public void helper(int[] arr,int[] arrk,int j,int max){
        if(max>ans)return;
        if(j==arr.length){
            ans=Math.min(ans,max);
            return ;
        }
        for(int i=0;i<arrk.length;i++){
            arrk[i]+=arr[j];
            helper(arr,arrk,j+1,Math.max(max,arrk[i]));
            arrk[i]-=arr[j];
        }
    }
}