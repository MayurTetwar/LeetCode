class Solution {
    Integer[][] memo;
    public String stoneGameIII(int[] arr) {
        int n=arr.length;
        memo=new Integer[n][2];
        int res=helper(arr,0,0);
        if(res<0)return "Bob";
        if(res>0)return "Alice";
        return "Tie";
    }
    public int helper(int[] arr,int i,int state){
        int n=arr.length;
        if(i==n)return 0;
        if(memo[i][state]!=null)return memo[i][state];
        if(state==0){
            int res1=-(int)1e9,res2=-(int)1e9,res3=-(int)1e9;
            if(i<n){
                res1=helper(arr,i+1,1-state)+arr[i];
            }
            if(i+1<n){
                res2=helper(arr,i+2,1-state)+arr[i]+arr[i+1];
            }
            if(i+2<n){
                res3=helper(arr,i+3,1-state)+arr[i]+arr[i+1]+arr[i+2];
            }
            return memo[i][state]=Math.max(res1,Math.max(res2,res3));
        }else{
            int res1=(int)1e9,res2=(int)1e9,res3=(int)1e9;
            if(i<n){
                res1=helper(arr,i+1,1-state)-arr[i];
            }
            if(i+1<n){
                res2=helper(arr,i+2,1-state)-arr[i]-arr[i+1];
            }
            if(i+2<n){
                res3=helper(arr,i+3,1-state)-arr[i]-arr[i+1]-arr[i+2];
            }
            return memo[i][state]=Math.min(res1,Math.min(res2,res3));
        }
    }
}