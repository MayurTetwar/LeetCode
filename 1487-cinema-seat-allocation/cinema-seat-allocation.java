class Solution {
    public int maxNumberOfFamilies(int n, int[][] arr) {
        int m=arr.length;
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        int ans=0;
        int j=0;
        int i=0;
        int last=0;
        while(j<m){
            boolean[] dp=new boolean[11];
            i=j;
            while(j<m && arr[i][0]==arr[j][0]){
                dp[arr[j][1]]=true;
                j++;
            }

            int curr=arr[i][0];
            ans+=(curr-last-1)*2;
            last=curr;
            int valid=3;
            for(int k=2;k<6;k++){
                if(dp[k]){
                    valid--;
                    break;
                }
            }
            for(int k=4;k<8;k++){
                if(dp[k]){
                    valid--;
                    break;
                }
            }
            for(int k=6;k<10;k++){
                if(dp[k]){
                    valid--;
                    break;
                }
            }
            if(valid==1)ans++;
            else if(valid>1)ans+=(valid-1);
        }
        ans+=(n-last)*2;
            // System.out.println(ans);
        return ans;
    }
}