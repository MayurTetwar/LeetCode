class Solution {
    public long maximumHappinessSum(int[] arr, int k) {
        int n=arr.length;
        Arrays.sort(arr);
        long sum=0;
        int sub=0;
        for(int i=n-1;i>=0 && k>0;i--){
            sum+=Math.max(arr[i]-sub,0);
            sub++;
            k--;
        }
        return sum;
    }
}