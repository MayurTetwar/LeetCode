class Solution {
    int[] memo;
    public int maxHeight(int[][] arr) {
        int[][][] map=new int[101][101][101];
        memo=new int[arr.length+1];
        Arrays.fill(memo,-1);
        for(int[] a:arr){
            Arrays.sort(a);
            map[a[0]][a[1]][a[2]]++;
        }
        List<int[]> list=new ArrayList<>();
        list.add(new int[]{0,0,0,0});
        for(int i=1;i<=100;i++){
            for(int j=1;j<=100;j++){
                for(int k=1;k<=100;k++){
                    if(map[i][j][k]>0)
                        list.add(new int[]{i,j,k,map[i][j][k]});
                }
            }
        }
        return helper(list,0);
    }
    public int helper(List<int[]> list,int i){
        if(memo[i]!=-1)return memo[i];
        int ans=0;
        int n=list.size();
        int[] up=list.get(i);
        for(int j=0;j<n;j++){
            if(i==j)continue;
            int[] down=list.get(j);
            if(up[0]<=down[0] && up[1]<=down[1] && up[2]<=down[2]){
                ans=Math.max(ans,helper(list,j)+down[3]*down[2]);
            }
        }
        return memo[i]=ans;
    }
}