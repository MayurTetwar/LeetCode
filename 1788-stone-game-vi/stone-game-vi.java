class Solution {
    public int stoneGameVI(int[] arr, int[] brr) {
        int n=arr.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->arr[b]+brr[b]-arr[a]-brr[a]); 
        for(int i=0;i<n;i++){
            pq.add(i);
        }
        boolean[] visi=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                int idx=pq.poll();
                ans+=arr[idx];
            }else{
                int idx=pq.poll();
                ans-=brr[idx];
            }
        }
        if(ans==0)return 0;
        if(ans<0)return -1;
        return 1;
    }
    /*
    1    99
    100   3

    */
}