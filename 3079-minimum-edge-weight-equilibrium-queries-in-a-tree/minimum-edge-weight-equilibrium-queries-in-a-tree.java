class Solution {
    List<List<int[]>> list;
    int n;
    int[] depth;
    int[][] up;
    int[][] count;
    int log;
    public int[] minOperationsQueries(int n, int[][] edges, int[][] que){
        this.n=n;
        log=0;
        while((1<<log)<=n)log++;
        depth=new int[n];
        up=new int[n][log+1];
        list=new ArrayList<>();
        count=new int[n][27];
        for(int i=0;i<n;i++){
            Arrays.fill(up[i],-1);
            list.add(new ArrayList<>());
        }
        for(int[] e:edges){
            list.get(e[0]).add(new int[]{e[1],e[2]});
            list.get(e[1]).add(new int[]{e[0],e[2]});
        }
        depth[0]=1;
        int[] currcount=new int[27];
        dfs(0,-1,currcount);
        
        // for(int[] d:up){
        //     System.out.println(Arrays.toString(d));
        // }
        for(int j=1;j<=log;j++){
            for(int i=0;i<n;i++){
                if(up[i][j-1]!=-1){
                    up[i][j]=up[up[i][j-1]][j-1];
                }else{
                    up[i][j]=-1;
                }
            }
        }

        int m=que.length;
        int[] ans=new int[m];
        for(int i=0;i<m;i++){
            int a=que[i][0];
            int b=que[i][1];
            int lca=getlca(a,b);
            // System.out.println(a+" "+b+" "+lca);
            currcount=new int[27];
            for(int j=1;j<27;j++){
                currcount[j]=count[a][j]-count[lca][j];
            }
            for(int j=1;j<27;j++){
                currcount[j]+=count[b][j]-count[lca][j];
            }
        
            int max=0;
            int total=0;
            for(int j=1;j<27;j++){
                max=Math.max(max,currcount[j]);
                total+=currcount[j];
            }
            //  System.out.println(Arrays.toString(currcount));
            ans[i]=total-max;
        }
        return ans;
    }
    public int getlca(int a,int b){
        if(depth[a]<depth[b]){
            int temp=a;
            a=b;
            b=temp;
        }
            // System.out.println(a+" "+b);
        for(int i=log;i>=0;i--){
            if(up[a][i]!=-1 && depth[a]-(1<<i)>=depth[b]){
                a=up[a][i];
            }
        }
        if(a==b)return a;
        for(int i=log;i>=0;i--){
            if(up[a][i]!=-1 && up[a][i]!=up[b][i]){
                a=up[a][i];
                b=up[b][i];
            }
        }
        return up[a][0];
    }
    public void dfs(int curr,int par,int[] currcount){
        up[curr][0]=par;
        count[curr]=currcount.clone();
        for(int[] neg:list.get(curr)){
            currcount[neg[1]]++;
            if(neg[0]!=par){
                depth[neg[0]]=depth[curr]+1;
                dfs(neg[0],curr,currcount);
            }
            currcount[neg[1]]--;
        }
    }
    // public 
}