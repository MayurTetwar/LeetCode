class Solution {
    public boolean isPowerOfFour(int n) {
        return helper(1,n);
    }
    public boolean helper(long num,int n){
        if(num>n)return false;
        if(num==n)return true;
        return helper(num*4,n);
    }
}