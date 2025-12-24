class Solution {
    public int minimumBoxes(int[] arr, int[] cap) {
        Arrays.sort(cap);
        int sum=0;
        for(int num:arr)sum+=num;
        int ans=0;
        for(int i=cap.length-1;i>=0 && sum>0;i--){
            sum=sum-cap[i];
            ans++;
        }
        return ans;
    }
}