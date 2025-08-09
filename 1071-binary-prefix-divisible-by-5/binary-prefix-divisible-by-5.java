class Solution {
    public List<Boolean> prefixesDivBy5(int[] arr) {
        int curr=0;
        List<Boolean> ans=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            curr=curr<<1;
            if(arr[i]==1){
                curr|=1;
            }
            if(curr%5==0)ans.add(true);
            else ans.add(false);
            curr=curr%5;
        }
        return ans;
    }
}