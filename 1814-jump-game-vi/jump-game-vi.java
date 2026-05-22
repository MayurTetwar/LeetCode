class Solution {
    public int maxResult(int[] arr, int k) {
        int n=arr.length;
        int[] ans=new int[n];
        ans[0]=arr[0];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->ans[b]-ans[a]);
        pq.add(0);
        for(int i=1;i<n;i++){
            while(pq.peek()<i-k){
                pq.poll();
            }
            ans[i]=arr[i]+ans[pq.peek()];
            pq.add(i);
        }
        return ans[n-1];
    }
}