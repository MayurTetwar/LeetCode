class Solution {
    Integer[][] memo;
    public int minScoreTriangulation(int[] arr) {
        memo=new Integer[arr.length][arr.length];
       return helper(arr,0,arr.length-1);
    }
    public int helper(int[] arr,int left,int right){
        if(left+1>right-1)return 0;
        if(left+1==right-1){
            return arr[left]*arr[left+1]*arr[right];
        }
        if(memo[left][right]!=null)return memo[left][right];
        int ans=Integer.MAX_VALUE;
        for(int mid=left+1;mid<right;mid++){
            ans=Math.min(ans,arr[left]*arr[right]*arr[mid]+helper(arr,left,mid)+helper(arr,mid,right));
        }
        return memo[left][right]=ans;
    }
}