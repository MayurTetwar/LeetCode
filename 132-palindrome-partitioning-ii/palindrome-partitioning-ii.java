class Solution {
    boolean[][] poli;
    Integer[] memo;
    public int minCut(String s) {
        int n=s.length();
        poli=new boolean[n][n];
        memo=new Integer[n];
        for(int i=0;i<n;i++){
            poli[i][i]=true;
            int left=i-1;
            int right=i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                poli[left][right]=true;
                left--;
                right++;
            }
            left=i-1;
            right=i;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                poli[left][right]=true;
                left--;
                right++;
            }
            left=i;
            right=i+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                poli[left][right]=true;
                left--;
                right++;
            }
        }
        return helper(s,0)-1;
    }
    public int helper(String s,int st){
        int res=s.length();
        int n=s.length();
        if(st==n)return 0;
        if(memo[st]!=null)return memo[st];
        for(int i=st;i<n;i++){
            if(poli[st][i]){
                res=Math.min(res,helper(s,i+1)+1);
            }
        }
        return memo[st]=res;
    }
}