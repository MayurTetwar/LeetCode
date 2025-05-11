class Solution {
    public int climbStairs(int n) {
        int total=0;
        if(n==1)return 1;
        if(n==2)return 2;
        int pre=1;
        int pre2=2;
        n-=2;
        while(n>0){
            total=pre+pre2;
            pre=pre2;
            pre2=total;
            n--;
        }
        return total;
    }
}