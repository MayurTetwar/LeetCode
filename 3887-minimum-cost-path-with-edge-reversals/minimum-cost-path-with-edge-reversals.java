class Solution {
    public int minCost(int n, int[][] arr) {
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b)->{
            return a[1]-b[1];
        });
        List<List<int[]>> list=new ArrayList<>();
        List<List<int[]>> revlist=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
            revlist.add(new ArrayList<>());
        }
        for(int[] a:arr){
            list.get(a[0]).add(new int[]{a[1],a[2]});
            revlist.get(a[1]).add(new int[]{a[0],a[2]});
        }
        boolean[] visi=new boolean[n];
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            if(visi[curr[0]])continue;
            visi[curr[0]]=true;
            if(curr[0]==n-1)return curr[1];
            for(int[] neg:list.get(curr[0])){
                pq.add(new int[]{neg[0],neg[1]+curr[1]});
            }
            for(int[] neg:revlist.get(curr[0])){
                pq.add(new int[]{neg[0],neg[1]*2+curr[1]});
            }
        }
        return -1;
    }
}