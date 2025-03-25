class Solution {
    public boolean isPowerOfFour(int n) {
     //   System.out.println(Integer.MAX_VALUE);
        return helper(1,n);
    }
    public boolean helper(long num,int n){
        if(num>n)return false;
        if(num==n)return true;
        return helper(num*4,n);
    }
}