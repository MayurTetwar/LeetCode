class Solution {
    Integer[][] memo;
    public int minSideJumps(int[] arr) {
        int n=arr.length;
        memo=new Integer[n][4];
        return helper(arr,0,2);
    }
    public int helper(int[] arr,int i,int len){
        int n=arr.length;
        if(i==n-1)return 0;
        if(memo[i][len]!=null)return memo[i][len];
        int res=(int)1e9;
        if(arr[i+1]==len){
            if(len!=1 && arr[i]!=1){
                res=Math.min(res,helper(arr,i+1,1)+1);
            }
            if(len!=2 && arr[i]!=2){
                res=Math.min(res,helper(arr,i+1,2)+1);
            }
            if(len!=3 && arr[i]!=3){
                res=Math.min(res,helper(arr,i+1,3)+1);
            }
        }else{
            res=helper(arr,i+1,len);
        }
        return memo[i][len]=res;
    }
}