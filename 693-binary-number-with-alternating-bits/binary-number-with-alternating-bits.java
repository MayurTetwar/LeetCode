class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n<=1)return true;
        int msb=31-Integer.numberOfLeadingZeros(n);
        int last=(n&1);
        for(int i=1;i<=msb;i++){
            if(last==((n>>i)&1)){
                return false;
            }
            last=1-last;
        }
        return true;
    }
}