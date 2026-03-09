class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        int n=arr.length;
        int count=1;
        int ans=0;
        int j=0;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(j<i && sum>goal){
                sum-=arr[j];
                j++;
                count=1;
            }
            while(j<i && arr[j]==0){
                j++;
                count++;
            }
            if(sum==goal){
                ans+=count;
            }
        }
        return ans;
        
    }
}