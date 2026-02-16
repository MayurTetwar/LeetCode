class Solution {
    public int reverseBits(int n) {
        int ans=0;
        int j=31;
        for(int i=0;i<32;i++){
            if(((n&(1<<i))!=0))ans=ans|(1<<j);
            j--;
        }
        return ans;
    }
}