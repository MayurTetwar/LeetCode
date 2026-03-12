class Solution {
    int[] par;
    public void union(int x,int y){
        int com1=find(x);
        int com2=find(y);
        if(com1!=com2){
            par[com1]=com2;
        }
    }
    public int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public int maxStability(int n, int[][] arr, int k) {
        par=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        int edges=n-1;
        int min=Integer.MAX_VALUE;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        List<int[]> unact=new ArrayList<>();
        for(int[] a:arr){
            if(a[3]==1){
                if(find(a[0])==find(a[1]))return -1;
                union(a[0],a[1]);
                min=Math.min(min,a[2]);
                edges--;
            }else{
                unact.add(new int[]{a[2],a[0],a[1]});
            }
        }

        unact.sort((a,b)->b[0]-a[0]);
        for(int[] a:unact){
            if(find(a[1])!=find(a[2])){
                union(a[1],a[2]);
                edges--;
                pq.add(a[0]);
            }
        }
        if(edges!=0)return -1;
        // System.out.println(pq);
        while(!pq.isEmpty() && k>0){
            min=Math.min(min,pq.poll()*2);
            k--;
        }
        if(!pq.isEmpty()){
            min=Math.min(min,pq.poll());
        }
        return min;
    }
}