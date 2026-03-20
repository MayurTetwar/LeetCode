class Solution {
    public int[][] minAbsDiff(int[][] arr, int k) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] ans=new int[n-k+1][m-k+1];
        for(int i=k-1;i<n;i++){
            for(int j=k-1;j<m;j++){
                PriorityQueue<Integer> pq=new PriorityQueue<>();
                for(int p=i-k+1;p<=i;p++){
                    for(int u=j-k+1;u<=j;u++){
                        pq.add(arr[p][u]);
                    }
                }
                int res=100000000;
                int prev=pq.poll();
                while(!pq.isEmpty()){
                    int curr=pq.poll();
                    if(curr!=prev)
                        res=Math.min(res,Math.abs(curr-prev));
                    prev=curr;
                }
                ans[i-k+1][j-k+1]=(res==100000000)?0:res;
            }
        }
        return ans;
    }
}