class Solution {
    public int numberOfArrays(int[] arr, int l, int u) {
        int n=arr.length;
        int min=0,max=0;
        int curr=0;
        for(int i=0;i<n;i++){
            curr+=arr[i];
            max=Math.max(max,curr);
            min=Math.min(min,curr);
            if(max-min>u-l)return 0;
        }
        return (u-l)-(max-min)+1;
    }
}
