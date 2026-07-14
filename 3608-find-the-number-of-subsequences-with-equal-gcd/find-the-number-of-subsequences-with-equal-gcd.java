class Solution {
    long mod=(long)1e9+7;
    long[][][] memo;
    public int subsequencePairCount(int[] arr) {
        int n=arr.length;
        memo=new long[n][201][201];
        for(long[][] mem:memo){
            for(long[] m:mem){
                Arrays.fill(m,-1);
            }
        }
        return (int)helper(arr,0,0,0)-1;
    }
    public long helper(int[] arr,int i,long g1,long g2){
        if(i==arr.length){
            if(g1==g2)return 1;
            return 0;
        }
        if(memo[i][(int)g1][(int)g2]!=-1)return memo[i][(int)g1][(int)g2];
        long res1=helper(arr,i+1,g1,g2);
        long res2=helper(arr,i+1,gcd(g1,arr[i]),g2);
        long res3=helper(arr,i+1,g1,gcd(g2,arr[i]));
        return memo[i][(int)g1][(int)g2]=(res1+res2+res3)%mod;
    }
    public long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}