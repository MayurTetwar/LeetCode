class Solution {
    public int uniqueXorTriplets(int[] arr) {
        int n=arr.length;
        if(n==1)return 1;
        if(n==2)return 2;
        int bit=getMSB(n)+1;
       // System.out.println(bit);
        int val=(int)Math.pow(2,bit);
        return val;
    }
    public int getMSB(int n) {
        return 31-Integer.numberOfLeadingZeros(n);
    }
}