class Solution {
    public boolean findSafeWalk(List<List<Integer>> list, int he) {
        int n=list.size();
        int m=list.get(0).size();
        boolean[][] visi=new boolean[n][m];
        int[][] dir={{0,-1},{-1,0},{0,1},{1,0}};

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[2]-a[2]);
        if(list.get(0).get(0)==1)he--;
        pq.add(new int[]{0,0,he});
        visi[0][0]=true;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            if(curr[2]==0)return false;
            if(curr[0]==n-1 && curr[1]==m-1)return true;
            for(int[] d:dir){
                int newi=curr[0]+d[0];
                int newj=curr[1]+d[1];
                int hel=curr[2];
                if(valid(newi,newj,n,m) && !visi[newi][newj]){
                    visi[newi][newj]=true;
                    if(list.get(newi).get(newj)==1){
                        hel--;
                    }
                    pq.add(new int[]{newi,newj,hel});
                }
            }
        }
        return true;
    }
    public boolean valid(int i,int j,int n,int m){
        if(i>=n || j>=m || i<0 || j<0)return false;
        return true;
    }
}