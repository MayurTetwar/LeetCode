class Solution {
    public int numRescueBoats(int[] arr, int limit) {
        int n=arr.length;
        Arrays.sort(arr);
        int ans=0;
        int i=0;
        int j=n-1;
        while(i<j){
            if(arr[i]+arr[j]<=limit){
                i++;
            }
            j--;
            ans++;
        }
        if(i==j)ans++;
        return ans;
    }
}