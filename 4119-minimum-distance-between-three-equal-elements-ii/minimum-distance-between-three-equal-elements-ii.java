class Solution {
    public int minimumDistance(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] right=new int[n];
        for(int i=n-1;i>=0;i--){
            right[i]=map.getOrDefault(arr[i],-1);
            map.put(arr[i],i);
        }
        int ans=3*n;
        map=new HashMap<>();
        map.put(arr[0],0);
        for(int i=1;i<n;i++){
            if(map.containsKey(arr[i]) && right[i]!=-1){
                int k=map.get(arr[i]);
                ans=Math.min(ans,Math.abs(k - i) + Math.abs(i - right[i]) + Math.abs(right[i] - k));
            }
            map.put(arr[i],i);
        }
        return (ans==3*n)?-1:ans;
    }
}