class Solution {
    public int shortestPathLength(int[][] arr) {
        int n = arr.length;
        int allmask = (1 << n) -1;
        boolean[][] visi=new boolean[allmask+1][n];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            int[] curr=new int[3];
            curr[0]=i;   // curr
            curr[1]=1;     // len
            curr[2]=(1<<i); // mask
            q.add(curr);
            visi[1<<i][i]=true;
        }
        while(!q.isEmpty()){
            int[] curr=q.poll();
            // System.out.println();
            if(curr[2]==allmask){
                return curr[1]-1;
            }
            for(int neg:arr[curr[0]]){
                int newmask =  curr[2] | (1 << neg);
                if(visi[newmask][neg]){
                    continue;
                }
                int newlen=curr[1]+1;
                q.add(new int[]{neg,newlen,newmask});
                visi[newmask][neg]=true;
            }
        }
        return -1;
    }
}