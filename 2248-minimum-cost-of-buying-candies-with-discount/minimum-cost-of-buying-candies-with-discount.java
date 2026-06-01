class Solution {
    public int minimumCost(int[] arr) {
        Arrays.sort(arr);
        int k=1;
        int ans=0;
        for(int i=arr.length-1;i>=0;i--){
            if(k%3!=0)ans+=arr[i];
            k++;
        }
        return ans;
    }
}