class Solution {
    public int totalMoney(int n) {
        int ans=0;
        int st=1;
        while(n>0){
            int curr=st;
            for(int i=0;i<7 && n>0;i++){
                ans+=(curr+i);
                n--;
            }
            st++;
        }
        return ans;
    }
}