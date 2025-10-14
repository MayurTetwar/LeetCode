class Solution {
    public int miceAndCheese(int[] arr1, int[] arr2, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return b[0]-a[0];
        });
        int n=arr1.length;
        for(int i=0;i<n;i++){
            pq.add(new int[]{arr1[i]-arr2[i],i});
        }
        int ans=0;
        while(k-->0){
            int i=pq.poll()[1];
            ans+=arr1[i];
        }
        while(!pq.isEmpty()){
            int i=pq.poll()[1];
            ans+=arr2[i];
        }
        return ans;
    }
}