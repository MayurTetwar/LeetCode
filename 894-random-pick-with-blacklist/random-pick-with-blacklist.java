class Solution {

    List<int[]> ans;
    int idx;
    int curr;
    public Solution(int n, int[] arr) {
        idx=0;
        ans=new ArrayList<>();
        Arrays.sort(arr);
        int prev=0;
        for(int i=0;i<arr.length;i++){
            if(prev<=arr[i]-1){
                ans.add(new int[]{prev,arr[i]-1});
            }
            prev=arr[i]+1;
        }
        if(prev<=n-1){
            ans.add(new int[]{prev,n-1});
        }
        curr=ans.get(0)[0];
    }
    
    public int pick() {
        if(curr>ans.get(idx)[1]){
            idx++;
            if(idx==ans.size())idx=0;
            curr=ans.get(idx)[0];
        }
        int val=curr;
        curr++;
        return val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */