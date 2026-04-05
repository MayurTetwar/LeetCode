class Solution {
    int[][] memo;
    public int minOperations(int[] arr, int k) {
        int n=arr.length;
        // if(n<3 || k==0)return 0;
        memo=new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],(int)-1e9);
        }
        // int ans=(int)1e9;
        int ans=helper(arr,n,n,1,k);
        memo=new int[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],(int)-1e9);
        }
        int ans2=helper(arr,n,n-1,0,k);
        // System.out.println(ans+" "+ans2);
        if(Math.min(ans,ans2)==(int)1e9)return -1;
        return Math.min(ans,ans2);
    }
    public int helper(int[] arr,int n,int end,int i,int k){
        if(k==0)return 0;
        if(i>=end)return (int)1e9;
        if(memo[i][k]!=(int)-1e9)return memo[i][k];
        
        int prev=(i==0)?arr[n-1]:arr[i-1];
        int next=(i==n-1)?arr[0]:arr[i+1];
        int res=helper(arr,n,end,i+1,k);
        if(arr[i]>prev && arr[i]>next){
            res=Math.min(res,helper(arr,n,end,i+2,k-1));
        }else{
            int req=Math.max(prev,next)-arr[i]+1;
            // System.out.println(prev+" "+next+" "+i+" "+req);
            if(k>0)res=Math.min(res,helper(arr,n,end,i+2,k-1)+req);
        }
        return memo[i][k]=res;
    }
}