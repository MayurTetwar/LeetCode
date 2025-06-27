class Solution {
    public int maxSubarrayLength(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int j=0;
        int ans=0;
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(map.get(arr[i])>k){
                map.put(arr[j],map.get(arr[j])-1);
                j++;
            }
            ans=Math.max(ans,i-j+1);
        }
        return ans;
    }
}