class Solution {
    public void wiggleSort(int[] arr) {
        int[] ans=arr.clone();
        Arrays.sort(ans);
        int n=arr.length;
        int j=1;
        int i=n-1;
        for(i=n-1;j<n;i--){
            arr[j]=ans[i];
            j+=2;
        }
        j=0;
        for(;j<n;i--){
            arr[j]=ans[i];
            j+=2;
        }
    }
}