class Solution {
    public List<List<Integer>> shiftGrid(int[][] arr, int k) {
        int n=arr.length;
        int m=arr[0].length;
        int[][] ans=new int[n][m];
        k=k%(n*m);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int idx=i*m+j;
                idx+=k;
                if(idx>=n*m)idx-=n*m;
                int newi=idx/m;
                int newj=idx%m;
                // System.out.println(newi+" "+newj+" "+k+" "+idx+" "+n+" "+m);
                ans[newi][newj]=arr[i][j];
            } 
            // System.out.println("--------");      
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<m;j++){
                l.add(ans[i][j]);
            }
            list.add(l);
        }
        return list;
    }
}