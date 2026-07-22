class Solution {
    public int findMaxLength(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        int ans=0;
        int count=0;
        for(int i=0;i<n;i++){
            count+=(arr[i]==1)?1:-1;
            if(map.containsKey(count)){
                ans=Math.max(ans,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return ans;
    }
}