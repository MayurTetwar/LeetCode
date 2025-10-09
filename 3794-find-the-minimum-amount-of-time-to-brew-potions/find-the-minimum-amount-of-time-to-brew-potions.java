class Solution {
    public long minTime(int[] arr, int[] mana) {
        int n=arr.length;
        int m=mana.length;
        long[] dp=new long[n];
        dp[0]=arr[0]*mana[0];
        for(int i=1;i<n;i++){
            dp[i]=dp[i-1]+arr[i]*mana[0];
        }
        for(int i=1;i<m;i++){
            // System.out.println(Arrays.toString(dp));
            long st=dp[0];
            long end=dp[n-1];
            while(st<=end){
                long mid=st+(end-st)/2;
                if(check(dp,arr,mana[i],mid)){
                    end=mid-1;
                }else{
                    st=mid+1;
                }
                // System.out.println(st+" "+end);
            }
            long corr=end+1;
            dp[0]=corr+arr[0]*mana[i];
            for(int j=1;j<n;j++){
                dp[j]=dp[j-1]+arr[j]*mana[i];
            }
        }
        return dp[n-1];
    }
    public boolean check(long[] dp,int[] arr,int m,long corr){
        for(int i=0;i<arr.length-1;i++){
            if((corr+arr[i]*m)<dp[i+1]){
                return false;
            }
            corr+=arr[i]*m;
        }
        return true;
    }
}