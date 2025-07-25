class Solution {
    int[] par;
    public int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public void union(int x,int y){
        int com1=find(x);
        int com2=find(y);
        if(com1==com2)return;
        par[com1]=com2;
    }
    public int cal(int x,int y,int a,int b){
        return Math.abs(x-a)+Math.abs(y-b);
    }
    public int minCostConnectPoints(int[][] arr) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[2]-b[2];
        });
        int n=arr.length;
        par=new int[n];
        for(int i=0;i<n;i++)par[i]=i;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
              //  System.out.println(i+" "+j);
                pq.add(new int[]{i,j,cal(arr[i][0],arr[i][1],arr[j][0],arr[j][1])});
            }
        }
        int ans=0;
        int eg=0;
        while(eg<n-1){
            int[] curr=pq.poll();
            // System.out.println(find(curr[0])+" "+find(curr[1]));
            if(find(curr[0])!=find(curr[1])){
                union(curr[0],curr[1]);
                ans+=curr[2];
                eg++;
            }
        }
        return ans;
    }
}