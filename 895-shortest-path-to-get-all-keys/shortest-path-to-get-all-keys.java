class Solution {
    public int shortestPathAllKeys(String[] arr) {
        int n=arr.length;
        int m=arr[0].length();

        int sti=0;
        int stj=0;
        int mask=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                char ch=arr[i].charAt(j);
                if(ch=='@'){
                    sti=i;
                    stj=j;
                }
                if(ch<='f' && ch>='a'){
                    mask=mask|(1<<(ch-'a'));
                }
            }
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->{
            return a[3]-b[3];
        });
        boolean[][][] visi=new boolean[n][m][mask+1];
        pq.add(new int[]{sti,stj,mask,0});
        visi[sti][stj][mask]=true;

        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
        // System.out.println(Arrays.toString(curr));
            if(curr[2]==0)return curr[3];
            int i=curr[0];
            int j=curr[1];
            for(int[] d:dir){
                int newi=i+d[0];
                int newj=j+d[1];
                mask=curr[2];   
                if(!valid(newi,newj,n,m))continue;
                char ch=arr[newi].charAt(newj);
                if(ch=='#')continue;
                if(ch>='A' && ch<='F' && (mask&(1<<(ch-'A')))!=0){
                    continue;
                }
                if(ch>='a' && ch<='f'){
                    mask=mask & (~(1<<(ch-'a')));
                }
                if(visi[newi][newj][mask])continue;
                visi[newi][newj][mask]=true;
                pq.add(new int[]{newi,newj,mask,curr[3]+1});
            }
        }
        return -1;
    }
    public boolean valid(int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m)return false;
        return true;
    }
}