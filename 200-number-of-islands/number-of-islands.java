class Solution {
    int[] par;
    int rows;
    int cols;
    int isLands;
    public int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public void union(int x,int y){
        int com=find(x);
        int com2=find(y);
        if(com==com2)return ;
        par[com]=com2;
        isLands--;
    }
    public void union(int m,int n,int x,int y){
        int ind1=getIndex(m,n);
        int ind2=getIndex(x,y);
        union(ind1,ind2);
    }
    public int getIndex(int x,int y){
        return x*cols+y;
    }
    public int[] getCoordinates(int index) {
        return new int[]{index / cols, index % cols};
    }
    public int numIslands(char[][] arr) {
        rows=arr.length;
        cols=arr[0].length;
        isLands=0;
        par=new int[rows*cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(arr[i][j]=='1'){
                    par[i*cols+j]=i*cols+j;
                    isLands++;
                }
            }
        }
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(arr[i][j]=='1'){
                    for(int d[]:dir){
                        int newi=i+d[0];
                        int newj=j+d[1];
                        if(newi>=0 && newj>=0 && newi<rows && newj<cols && arr[newi][newj]=='1'){
                            union(i,j,newi,newj);
                        }
                    }
                }
            }
        }
        return isLands;
    }
}