class Solution {
    public int maxOperations(String s) {
        int ans=0;
        int n=s.length();
        int cnt=0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='1')cnt++;
            if(s.charAt(i)=='1' && s.charAt(i+1)=='0'){
                ans+=cnt;
            }
        }
        return ans;
    }
}