class Solution {
    public int[] getConcatenation(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n*2];
        for(int i=0;i<n;i++){
            ans[i]=arr[i];
        }
        int j=n;
        for(int i=0;i<n;i++){
            ans[j++]=arr[i];
        }
        return ans;
    }
}