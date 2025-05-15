class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int[][] pos=new int[n][2];
        for(int i=0;i<n;i++){
            pos[i][0]=arr[i];
            pos[i][1]=i;
        }
        Arrays.sort(pos, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp=new int[n];
        int max=0;
        for(int i=n-1;i>=0;i--){
            int currmax=0;
            for(int j=i+1;j<n;j++){
                if(pos[i][1]<pos[j][1] && pos[i][0]!=pos[j][0]){
                    currmax=Math.max(currmax,dp[j]);
                }
            }
            dp[i]=currmax+1;
            // System.out.println(currmax);
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}