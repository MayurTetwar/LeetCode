class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] ans=new int[k];
        int[] arr=nums.clone();
        Arrays.sort(arr);
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=n-1;k>0;i--){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            k--;
        }
        k=0;
        for(int i=0;i<n && k<ans.length;i++){
            if(map.containsKey(nums[i]) && map.get(nums[i])>0){
                ans[k++]=nums[i];
                map.put(nums[i],map.get(nums[i])-1);  
            }
        }
        return ans;
    }
}