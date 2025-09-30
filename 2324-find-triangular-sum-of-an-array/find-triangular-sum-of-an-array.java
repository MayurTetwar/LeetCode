class Solution {
    public int triangularSum(int[] arr) {
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            int[] brr=new int[n-i-1];
            for(int j=0;j<n-i-1;j++){
                brr[j]=(arr[j]+arr[j+1])%10;
            }
            arr=brr;
            // System.out.println(Arrays.toString(arr)+" "+i);
        }
        return arr[0];
    }
}