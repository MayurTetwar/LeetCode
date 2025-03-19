class Solution {
    public String rankTeams(String[] arr) {
        
        StringBuilder str=new StringBuilder();
        int n=arr.length;
        int m=arr[0].length();
        int[][] dp=new int[26][m+1];
        for(int i = 0; i < 26; i++) dp[i][m] = i;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[arr[i].charAt(j)-'A'][j]++;
            } 
        }
        Arrays.sort(dp,(a,b)->{
            for(int i=0;i<m;i++){
                if(a[i]<b[i])return 1;
                if(a[i]>b[i])return -1;
            }
            return 0;
        });
        for(int i=0;i<m;i++){
            str.append((char)('A'+dp[i][m]));
        }
        return str.toString();
    }
}