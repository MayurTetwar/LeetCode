class Solution {
    int[] par;
    int n;
    public int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public void union(int x,int y){
        int com1=find(x);
        int com2=find(y);
        if(com1==com2)return ;
        par[com1]=com2;
    }
    public int[] lexicographicallySmallestArray(int[] arr, int limit) {
        n=arr.length;
        par=new int[n];
        PriorityQueue<Integer>[] parr=new PriorityQueue[n];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return arr[a]-arr[b];
        });
        for(int i=0;i<n;i++){
            par[i]=i;
            pq.add(i);
            parr[i]=new PriorityQueue<>();
        }
       
        int a=pq.poll();
        while(pq.size()>0){
            int b=pq.poll();
            if((arr[b]-arr[a])<=limit)union(a,b);
            a=b;
        }
        for(int i=0;i<n;i++){
            parr[find(i)].add(arr[i]);
        }
        for(int i=0;i<n;i++){
            int com=find(i);
            arr[i]=parr[com].poll();
        }
        return arr;
    }
}