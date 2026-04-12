class Solution {
    int[][] map;
    int[][][] memo;
    public int minimumDistance(String str) {
        int n=str.length();
        memo=new int[n][27][27];
        // int n=str.length();
        for(int i=0;i<n;i++){
            for(int j=0;j<27;j++){
                Arrays.fill(memo[i][j],-1);
            }
        }
        map=new int[26][2];
        int j=0;
        int k=0;
        for(int i=0;i<26;i++){
            if(i%6==0){
                k=0;
                j++;
            }else{
                k++;
            }
            map[i]=new int[]{j,k};
        }
        return helper(str,0,26,26);
    }
    public int helper(String s,int i,int let1,int let2){
        if(s.length()==i)return 0;
        if(memo[i][let1][let2]!=-1)return memo[i][let1][let2];
        int next=s.charAt(i)-'A';
        int res1=helper(s,i+1,next,let2);
        int res2=helper(s,i+1,let1,next);
        if(let1!=26)res1+=dis(map[let1],map[next]);
        if(let2!=26)res2+=dis(map[let2],map[next]);
        return memo[i][let1][let2]=Math.min(res1,res2);
    }
    public int dis(int[] a,int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}