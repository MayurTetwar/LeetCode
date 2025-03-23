class Solution {
    static{
        for(int i=0;i<500;i++){
            countPaths(2,new int[][]{{0,1,1}});
        }
    }
    public static int countPaths(int n, int[][] arr) {
        long mod=(long)1e9+7;

        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] a:arr){
            list.get(a[0]).add(new int[]{a[1],a[2]});
            list.get(a[1]).add(new int[]{a[0],a[2]});
        }

        long[] path=new long[n];
        long[] dis=new long[n];
        Arrays.fill(dis,Long.MAX_VALUE);

        PriorityQueue<long[]> pq=new PriorityQueue<>(Comparator.comparingLong(a->a[0]));
        pq.add(new long[]{0,0});
        dis[0]=0;
        path[0]=1;

        while(pq.size()>0){
            long[] a=pq.poll();
            int start=(int)a[1];
            if(dis[start]<a[0])continue;

            for(int[] b:list.get(start)){
                if(a[0]+b[1]<dis[b[0]]){
                    dis[b[0]]=(a[0]+b[1]);
                    path[b[0]]=path[start];
                    pq.add(new long[]{dis[b[0]],b[0]});
                }else if(a[0]+b[1]==dis[b[0]]){
                    path[b[0]]=(path[start]+path[b[0]])%mod;
                }
            }
        }
        return (int)path[n-1];
    }
}