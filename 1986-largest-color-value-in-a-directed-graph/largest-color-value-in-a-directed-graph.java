class Solution {
    public int largestPathValue(String s, int[][] arr) {
        int n=s.length();
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] a:arr){
            list.get(a[0]).add(a[1]);
        }
        int max=-1;
        int round=1;
        for(int i=0;i<26;i++){
            int[] visi=new int[n];
            int[] dp=new int[n];
            char ch=(char)(i+'a');
            for(int j=0;j<n;j++){
                if(ch!=s.charAt(j))continue;
                int res=helper(s,ch,list,j,visi,dp,round);
                if(res==-1)return -1;
                max=Math.max(res+1,max);
                round++;
            }

        }
        return max;
    }
    public int helper(String s,char ch,List<List<Integer>> list,int curr,int[] visi,int[] dp,int round){
        if(visi[curr]==-1)return dp[curr];
        if(visi[curr]==round)return -1;
        visi[curr]=round;
        int ans=0;
        for(int next:list.get(curr)){
            int res=helper(s,ch,list,next,visi,dp,round);
            if(res==-1)return -1;
            if(s.charAt(next)==ch)res++;
            ans=Math.max(ans,res);
        }
        visi[curr]=-1;
        return dp[curr]=ans;
    }
}