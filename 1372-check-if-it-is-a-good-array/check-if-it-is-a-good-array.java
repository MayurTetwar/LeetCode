class Solution {
    public boolean isGoodArray(int[] arr) {
        int n=arr.length;
        int num=arr[0];
        for(int i=1;i<n;i++){
            num=gcd(num,arr[i]);
        }
        if(num==1)return true;
        return false;
    }
    public int gcd(int a,int b){
        if(b==0)return a;
        return gcd(b,a%b);
    }
}