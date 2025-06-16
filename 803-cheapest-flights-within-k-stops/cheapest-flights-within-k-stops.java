class Solution {
    class Cell{
        int price;
        int i;
        int k;
        Cell(int i,int price,int k){
            this.price=price;
            this.i=i;
            this.k=k;
        }
    }
    public int findCheapestPrice(int n, int[][] arr, int src, int dst, int k) {
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] a:arr){
            list.get(a[0]).add(new int[]{a[1],a[2]});
        }
        Queue<Cell> pq=new LinkedList<>();
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.add(new Cell(src,0,k));
        while(pq.size()>0){
            Cell curr=pq.poll();
            if(curr.k<0)continue;
            for(int[] neg:list.get(curr.i)){
                if(curr.price+neg[1]<dist[neg[0]]){
                dist[neg[0]]=curr.price+neg[1];
                pq.add(new Cell(neg[0],curr.price+neg[1],curr.k-1));
                }
            }
        }
        return (dist[dst]==Integer.MAX_VALUE)?-1:dist[dst];
    }
}