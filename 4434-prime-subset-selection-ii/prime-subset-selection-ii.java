class Solution {
    int[][] dp;
    int inf=(int)1e9;
    public List<Integer> maxPrimeSubset(int n, int s) {
        List<Integer> list=getPrimeUpToN(n);
        int k=list.size();
        dp=new int[k+1][s+1];
        for(int i=0;i<k;i++){
            Arrays.fill(dp[i],-1);
        }
        int sum=s;
        int count=0;
        while(sum>0){
            int res=helper(list,0,sum);
            // System.out.println(res);
            if(res!=inf){
                count=res;
                break;
            }
            sum--;
        }

        // for(int i=0;i<k;i++){
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        List<Integer> ans=new ArrayList<>();
        int i=0;
        while(i<k && count>0){
            int p=list.get(i);
            if(sum>=p && dp[i+1][sum-p]==count-1){
                sum-=p;
                ans.add(p);
                count--;
            }
            i++;
        }

        return ans;
    }
    public int helper(List<Integer> list,int i,int s){
        int n=list.size();
        if(s==0)return dp[i][s]=0;
        if(i==n)return inf;
        if(dp[i][s]!=-1)return dp[i][s];
        int p=list.get(i);
        int res1=helper(list,i+1,s);
        int res2=inf;
        if(s>=p){
            res2=helper(list,i+1,s-p);
            if(res2!=inf){
                res2++;
            }
        }
        return dp[i][s]=Math.min(res1,res2);
    }
    public List<Integer> getPrimeUpToN(int n) {
        List<Integer> list = new ArrayList<>();
        boolean[] visi = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            if (!visi[i]) {
                list.add(i);
                for (long j = (long) i * i; j <= n; j += i) visi[(int) j] = true;
            }
        }
        return list;
    }
}