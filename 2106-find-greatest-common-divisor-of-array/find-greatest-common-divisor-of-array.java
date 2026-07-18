class Solution {
    public int findGCD(int[] arr) {
        Arrays.sort(arr);
        return gcd(arr[0],arr[arr.length-1]);
    }
    public int gcd(int a,int b){
        if(a==0)return b;
        return gcd(b%a,a);
    }
}