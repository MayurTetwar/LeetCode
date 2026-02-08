class Solution {
    Integer memo[][];
    public int mctFromLeafValues(int[] arr) {
        int n=arr.length;
        memo=new Integer[n][n];
        return helper(arr,0,arr.length-1);
    }
    public int helper(int[] arr,int st,int end){
        if(st==end){
            return 0;
        }else{
            if(memo[st][end]!=null)return memo[st][end];
            int ans=Integer.MAX_VALUE;
            for(int mid=st;mid<end;mid++){
                int max1=0;
                int max2=0;
                for(int i=st;i<=mid;i++)max1=Math.max(max1,arr[i]);
                for(int i=mid+1;i<=end;i++)max2=Math.max(max2,arr[i]);
                int root=max1*max2;
                ans=Math.min(ans,root+helper(arr,st,mid)+helper(arr,mid+1,end));
            }
            memo[st][end]=ans;
            return ans;
        }
    }
}