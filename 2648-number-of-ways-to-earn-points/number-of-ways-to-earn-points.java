class Solution {
    long[][] memo;
    long mod=1000000007;
    public int waysToReachTarget(int tar, int[][] arr) {
        int n=arr.length;
        memo=new long[tar+1][n];
        for(int i=0;i<=tar;i++){
            Arrays.fill(memo[i],-1);
        }
        return (int)helper(arr,tar,0);
    }
    public long helper(int[][] arr,int tar,int i){
        if(i==arr.length){
            if(tar==0)return 1;
            return 0;
        }
        if(memo[tar][i]!=-1)return memo[tar][i];
        int qcount=arr[i][0];
        int mark=arr[i][1];
        long res=0;
        for(int j=0;j<=qcount;j++){
            if(tar-j*mark<0)break;
            res=(res+helper(arr,tar-j*mark,i+1))%mod;
        }
        return memo[tar][i]=res;
    }
}