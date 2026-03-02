class Solution {
    public long maxScore(int n, int[][] arr) {
        long ans=0;
        int edge=arr.length;
        for(int i=n;i>=3;i--){
            ans+=(long)i*(i-2);
        }
        ans+=(long)n*(n-1);
        if(n==edge){
            ans+=2;
        }
        return ans;
    }
}