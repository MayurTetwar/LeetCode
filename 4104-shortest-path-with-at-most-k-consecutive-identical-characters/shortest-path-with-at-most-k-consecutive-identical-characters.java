class Solution {
    public int shortestPath(int n, int[][] edges, String s, int k) {
        int m=edges.length;
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] ed:edges){
            list.get(ed[0]).add(new int[]{ed[1],ed[2]});
        }
        int[][] dis = new int[n][k + 1];
        for (int[] row : dis) {
            Arrays.fill(row, (int)1e9);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) ->
            Integer.compare(a[1], b[1])
        );
        pq.add(new int[]{0,0,1});
        dis[0][1]=0;
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            if(curr[0]==n-1)return curr[1];
            if (curr[1] > dis[curr[0]][curr[2]]) continue; 
            for(int[] next:list.get(curr[0])){
                int newk=curr[2];
                if(s.charAt(curr[0])==s.charAt(next[0]))newk++;
                else newk=1;
                if(newk<=k && curr[1]+next[1]<dis[next[0]][newk]){
                    dis[next[0]][newk]=curr[1]+next[1];
                    pq.add(new int[]{next[0],dis[next[0]][newk],newk});
                }
            }
        }
        return -1;
    }
}