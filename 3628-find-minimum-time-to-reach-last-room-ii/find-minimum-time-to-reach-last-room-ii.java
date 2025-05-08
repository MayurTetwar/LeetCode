class Solution {
    class Node{
        int i;
        int j;
        int val;
        int sec;
        public Node(int i,int j,int val,int sec){
            this.i=i;
            this.j=j;
            this.val=val;
            this.sec=sec;
        }
    }
    public int minTimeToReach(int[][] arr) {
        int[][] dir={{0,1},{1,0},{-1,0},{0,-1}};
        int n=arr.length;
        int m=arr[0].length;
        PriorityQueue<Node> pq=new PriorityQueue<>((a,b)->a.val-b.val);

        boolean[][] visi=new boolean[n][m];
        int[][] dist=new int[n][m];

        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        pq.add(new Node(0,0,0,2));
        int count=1;
        visi[0][0]=true;
        dist[0][0]=0;
        while(pq.size()>0){
            Node curr=pq.poll();
            visi[curr.i][curr.j]=true;
            if(curr.i==n-1 && curr.j==m-1)return curr.val;
            for(int[] d:dir){
                int newi=curr.i+d[0];
                int newj=curr.j+d[1];
                if(valid(newi,newj,n,m) && !visi[newi][newj]){
                    int sec=(curr.sec%2==0)?1:2;
                    //System.out.println(curr.sec+" "+sec);
                    int newdist=Math.max(arr[newi][newj],dist[curr.i][curr.j])+sec;
                    if(newdist<dist[newi][newj]){
                        dist[newi][newj]=newdist;
                    // //System.out.println(newi+" "+newj+" "+newdist);
                        pq.add(new Node(newi,newj,newdist,sec));
                        // count++;
                    }
                }
                // for(Node no:pq){
                //     //System.out.println(no.i+" "+no.j+" "+no.val+" "+no.sec);
                // }
                //System.out.println();
            }
        }
        return dist[n-1][m-1];
    }
    public boolean valid(int i,int j,int n, int m){
        if(i>=n || j>=m || i<0 || j<0)return false;
        return true;
    }
}