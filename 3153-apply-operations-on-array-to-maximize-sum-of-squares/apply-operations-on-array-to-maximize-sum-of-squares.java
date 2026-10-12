class Solution {
    public int maxSum(List<Integer> list, int k) {
        int n=list.size();
        int[] count=new int[32];
        long mod=(long)1e9+7;
        for(int i=0;i<n;i++){
            for(int j=0;j<32;j++){
                if((list.get(i)&(1<<j))!=0)count[j]++;
            }
        }
        long ans=0;
        while(k-->0){
            long num=0;
            for(int i=0;i<32;i++){
                if(count[i]>0){
                    count[i]--;
                    num=num|(1<<i);
                }
            }
            ans=(ans+(num*num)%mod)%mod;
        }
        return (int)ans;
    }
}