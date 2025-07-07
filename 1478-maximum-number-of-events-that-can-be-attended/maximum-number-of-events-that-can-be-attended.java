class Solution {
    public int maxEvents(int[][] arr) {

        int max=0;
        for(int[] a:arr){
            max=Math.max(max,a[1]);
        }

        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0])return a[0]-b[0];
            return a[1]-b[1];
        });

        int ans=0;
        int n=arr.length;
        int curr=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=1;i<=max;i++){
            while(curr<n && arr[curr][0]<=i){
                pq.add(arr[curr][1]);
                curr++;
            }
            while(pq.size()>0 && pq.peek()<i){
                pq.poll();
            }
            if(pq.size()>0){
                pq.poll();
                ans++;
            }
        }
        return ans;
    }
}