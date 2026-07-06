class Solution {
    public long totalCost(int[] arr, int k, int candidates) {
        long ans=0;
        int n=arr.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            if(a[0]==b[0])return a[1]-b[1];
            return a[0]-b[0];
        });
        int left=0;
        int right=n-1;
        for(int i=0;i<candidates;i++){
            pq.add(new int[]{arr[left++],0});
        }
        for(int i=n-1;i>=n-candidates && right>=left;i--){
            pq.add(new int[]{arr[right--],1});
        }
        while(k-->0){
            int[] curr=pq.poll();
           // System.out.println(curr[0]+" "+curr[1]);
            if(curr[1]==0){
                ans+=curr[0];
                if(left<=right){
                    pq.add(new int[]{arr[left++],0});
                }
            }else{
                ans+=curr[0];
                if(left<=right){
                    pq.add(new int[]{arr[right--],1});
                }
            }
        }
        return ans;
    }
}