class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            int val=n;
            int pro=1;
            while(val>0){
                pro*=(val%10);
                val/=10;
            }
            if(pro%t==0)return n;
            n++;
        }
    }
}