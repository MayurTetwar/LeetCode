class Solution {
    public int bulbSwitch(int n) {
        int ans=1;
        if(n==0)return 0;
        int curr=0;
        int i=0;
        while(curr<=n){
            ans++;
            curr=ans*ans;
        }
        return ans-1;
    }
    // 1 - 3 1
    // 4 - 8 2
    // 9 - 15 3
    // 16 -  24  4
    // 25 -
    // 1 1 1 1
    // 1 0 1 0
    // 1 0 0 0
    // 1 0 0 1
    // 1 1 1 1 1 1 1 1
    // 1 0 1 0 1 0 1 0
    // 1 0 0 0 1 1 1 0
    // 1 0 0 1 1 1 1 1
    // 1 0 0 1 0 1 1 1
    // 1 0 0 1 0 0 1 1
    // 1 0 0 1 0 0 0 1


}