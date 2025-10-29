class Solution {
    public int minKBitFlips(int[] arr, int k) {
        int ans=0;
        int n=arr.length;
        int[] dp=new int[n];
        int curr=0;
        for(int i=0;i<n;i++){
            curr+=dp[i];
            if(arr[i]==0){
                if(curr%2==0){
                    ans++;
                    curr++;
                    if(i+k>n)return -1;
                    if(i+k<n)dp[i+k]--;
                }
            }else{
                if(curr%2==1){
                    ans++;
                    curr++;
                    if(i+k>n)return -1;
                    if(i+k<n)dp[i+k]--;
                }
            }
        }
        // System.out.println(curr);
        // System.out.println(Arrays.toString(dp));
        return ans;
    }
}
/*
0 1 1 0

1 2 2 1 -1
*/