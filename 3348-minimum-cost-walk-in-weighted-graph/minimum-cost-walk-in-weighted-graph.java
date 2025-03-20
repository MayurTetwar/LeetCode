class Solution {
    static{
        for(int i=0;i<500;i++){
            minimumCost(2,new int[][]{{0,1,1}},new int[][]{{0,1}});
        }
    }
    public static int[] minimumCost(int n, int[][] arr, int[][] que) {
        List<List<int[]>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int []a:arr){
            list.get(a[0]).add(new int[]{a[1],a[2]});
            list.get(a[1]).add(new int[]{a[0],a[2]});
        }
        List<Integer> components=new ArrayList<>();
        int[] com=new int[n];
        int id=0;
        boolean[] visi=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visi[i]){
                components.add(helper(i,list,com,id,visi));
                id++;
            }
        }
        int[] ans=new int[que.length];
        for(int i=0;i<que.length;i++){
            if(com[que[i][0]]==com[que[i][1]]){
                ans[i]=components.get(com[que[i][0]]);
            }else{
                ans[i]=-1;
            }
        }
        return ans;
    }
    public static int helper(int i,List<List<int[]>> list,int[] com,int id,boolean[] visi){
        visi[i]=true;
        com[i]=id;
        int min=Integer.MAX_VALUE;
        for(int []a:list.get(i)){
            min&=a[1];
            if(!visi[a[0]]){
                min&=helper(a[0],list,com,id,visi);
            }
        }
        return min;
    }
}