class Solution {
    public int minDeletionSize(String[] arr) {
        int n=arr.length;
        int len=arr[0].length();
        int ans=0;
        for(int i=0;i<len;i++){
            for(int j=0;j<n-1;j++){
                if(arr[j].charAt(i)>arr[j+1].charAt(i)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}