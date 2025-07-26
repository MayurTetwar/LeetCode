class Solution {
    public int swimInWater(int[][] arr) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[0]-b[0];
        });
        int n=arr.length;
        boolean[][] visi=new boolean[n][n];
        int[][] dir=new int[][]{{0,-1},{-1,0},{0,1},{1,0}};
        int ans=arr[0][0];
        visi[0][0]=true;
        pq.add(new int[]{ans,0,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            ans=Math.max(ans,curr[0]);
            if(curr[1]==n-1 && curr[2]==n-1){
                return ans;
            }
            for(int[] d:dir){
                int newi=curr[1]+d[0];
                int newj=curr[2]+d[1];
                if(valid(newi,newj,n) && !visi[newi][newj]){
                    visi[newi][newj]=true;
                    pq.add(new int[]{arr[newi][newj],newi,newj});
                }
            }
        }
        return -1;
    }
    public boolean valid(int i,int j,int n){
        if(i<0 || j<0 || i>=n || j>=n)return false;
        return true;
    }
}