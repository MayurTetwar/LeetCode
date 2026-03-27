class Solution {
    Integer[] memo;
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        memo=new Integer[n];
        return helper(arr,-1);
    }
    public int helper(int[] arr,int i){
        int n=arr.length;
        if(i==n)return 0; 
        if(i!=-1 && memo[i]!=null)return memo[i];
        int res=0;
        for(int j=i+1;j<n;j++){
            if(i==-1){
                res=Math.max(res,helper(arr,j)+1);
            }else if(arr[i]<arr[j])
                res=Math.max(res,helper(arr,j)+1);
        }
        if(i!=-1)memo[i]=res;
        return res;
    }
}