class Solution {
    public long minNumberOfSeconds(int h, int[] arr) {
        long ans=0;
        int n=arr.length;
        PriorityQueue<long[]> pq=new PriorityQueue<>((a, b)->Long.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            pq.add(new long[]{arr[i],arr[i],1});
        }
        for(int i=0;i<h;i++){
            long[] curr=pq.poll();
            ans=Math.max(ans,curr[0]);
            curr[2]++;
            curr[0]+=curr[1]*curr[2];
            pq.add(curr);
        }
        return ans;
    }
}