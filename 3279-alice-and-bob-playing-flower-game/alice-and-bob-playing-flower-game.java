class Solution {
    public long flowerGame(int n, int m) {
        long e1=n/2;
        long o1=(n%2==0)?e1:e1+1;
        long e2=m/2;
        long o2=(m%2==0)?e2:e2+1;

        return e1*o2+e2*o1;
    }
}