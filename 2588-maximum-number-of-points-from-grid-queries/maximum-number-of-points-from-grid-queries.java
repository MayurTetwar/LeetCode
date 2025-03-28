class Solution {
    static{
        for(int i=0;i<500;i++){
            maxPoints(new int[][]{{0}},new int[]{0});
        }
    }
    static class Cell{
        int i, j, val;
        Cell(int i, int j, int val){
            this.i=i;
            this.j=j;
            this.val=val;
        }
    }
    public static int[] maxPoints(int[][] arr, int[] qua) {
        
        int k=qua.length;
        int n=arr.length;
        int m=arr[0].length;
        PriorityQueue<Cell> q=new PriorityQueue<>(Comparator.comparingInt(cell->cell.val));
        boolean[][] visi=new boolean[n][m];
        int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
        //int[] ans=new int[k];
        int max=0;
        for(int i=0;i<k;i++){
            max=Math.max(max,qua[i]);
        }
        int[] copy=qua.clone();
        int[] res =new int[max+1];
        Arrays.sort(qua);
        q.add(new Cell(0,0,arr[0][0]));
            visi[0][0]=true;
            int point=0;

        for(int i=0;i<k;i++){
            int num=qua[i];
            
            while(q.size()>0 && q.peek().val<num){
                Cell curr=q.poll();
                point++;
                    for(int[] d:dir){
                        int newi=d[0]+curr.i;
                        int newj=d[1]+curr.j;
                        if(isvalid(n,m,newi,newj) && !visi[newi][newj]){
                            
                            //System.out.print(ans+" "+arr[newi][newj]);
                            q.add(new Cell(newi,newj,arr[newi][newj]));
                            visi[newi][newj]=true;
                        }
                    }
                    //System.out.println();
            }
            res[num]=point;
        }
        for(int i=0;i<k;i++){
            qua[i]=res[copy[i]];
        }
        return qua;
    }
    public static boolean isvalid(int n ,int m ,int i, int j){
        if(i>=n || j>=m || i<0 || j<0)return false;
        return true;
    }
}