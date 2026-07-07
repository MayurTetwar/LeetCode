class Solution {
    public long sumAndMultiply(int n) {
        long numr=0;
        long sum=0;
        while(n>0){
            if(n%10!=0){
                numr=numr*10+(n%10);
            }
            sum+=n%10;
            n/=10;
        }
        long num=0;
        while(numr>0){
            num=num*10+(numr%10);
            numr/=10;
        }
        return sum*num;
    }
}