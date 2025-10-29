class Solution {
    public int smallestNumber(int n) {
        int ans=0;
        int i=0;
        while(n>0){
            ans=(ans|(1<<i));
            n/=2;
            i++;
        }
        return ans;
    }
}