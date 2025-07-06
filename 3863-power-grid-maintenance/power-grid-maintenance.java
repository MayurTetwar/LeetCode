class Solution {
    public class DSU {
        int[] par;
        int n;
        public DSU(int n){
            this.n=n;
            par=new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
            }
        }
        public int find(int x){
            if(x!=par[x]){
                par[x]=find(par[x]);
            }
            return par[x];
        }
        public boolean isConnected(int x,int y){
            return find(x)==find(y); 
        }
        public void merge(int x,int y){
            int com1=find(x);
            int com2=find(y);
            if(com1==com2)return ;
            par[com2] = com1;
        }
    }
    public int[] processQueries(int c, int[][] con, int[][] que) {
        Solution sol = new Solution();
        DSU dsu = sol.new DSU(c+1);
        for(int[] co:con){
            dsu.merge(co[0],co[1]);
        }

        PriorityQueue<Integer>[] list=new PriorityQueue[c+1];
        for(int i=1;i<=c;i++){
            int root=dsu.find(i);
            PriorityQueue<Integer> pq=list[root];
            if(pq==null){
                pq=new PriorityQueue<>();
            }
            pq.add(i);
            list[root]=pq;
        }
        List<Integer> ans=new ArrayList<>();
        boolean[] off=new boolean[c+1];

        for(int q[]:que){
            if(q[0]==2){
                off[q[1]]=true;
            }else{
                if(!off[q[1]]){
                    ans.add(q[1]);
                }else{
                    int root=dsu.find(q[1]);
                    PriorityQueue<Integer> pq=list[root];
                    while(pq.size()>0 && off[pq.peek()]){
                        pq.poll();
                    }
                    if(pq.size()>0)ans.add(pq.peek());
                    else ans.add(-1);
                }
            }
        }

        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        } 
        return res;
    }
}