class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = (int) (1e9 + 7);
        int prefix=0;
        int e=1,o=0;
        int ans=0;
        for(int num:arr){
            prefix+=num;
            if(prefix%2==0){
                ans+=o;
                e++;
            }else{
                ans+=e;
                o++;
            }
            ans=ans%MOD;    
        }
        return ans%MOD;
    }
}