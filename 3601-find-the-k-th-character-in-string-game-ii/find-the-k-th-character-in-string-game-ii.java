class Solution {
    public char kthCharacter(long k, int[] op) {
        long len=1;
        int total=0;
        while(len<k){
            len*=2;
            total++;
        }
        k--;
        int ans=0;
        for(int i=total-1;i>=0;i--){
            if(k>=len/2){
                if(op[i]==1){
                    ans++;
                }
                k-=len/2;
            }
            len/=2;
        }
       // System.out.println(ans);
        return (char)('a'+(ans%26));
    }
}