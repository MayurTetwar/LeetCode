class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int[] pre=new int[n];
        int ans=n;
        int count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='b')count++;
            pre[i]=count;
        }
        count=0;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='a')count++;
            ans=Math.min(ans,count+pre[i]-1);
        }
        return ans;
    }
}