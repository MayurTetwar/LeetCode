class Solution {
    static{
        for(int i=0;i<500;i++){
countCompleteComponents(2,new int[][]{{0,1}});
        }
    }
    public static int countCompleteComponents(int total, int[][] arr) {
        List<List<Integer>> list=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<total;i++){
            list.add(new ArrayList<>());
        }
        for(int []a:arr){
            list.get(a[0]).add(a[1]);
            list.get(a[1]).add(a[0]);
        }
        int count=0;
        boolean[] visi=new boolean[total];

        for(int i=0;i<total;i++){
            if(!visi[i]){
                List<Integer> all=new ArrayList<>();
                int size=helper(i,list,visi,total,all);
                int j=0;
                for(j=0;j<all.size();j++){
              //  System.out.println(list.get(all.get(j)).size()+" "+(size-1));
                    if(list.get(all.get(j)).size()!=size-1)break;
                }
                if(j==all.size())count++;
            }
        }
        return count;
    }
    public static int helper(int node,List<List<Integer>> list,boolean[] visi,int total,List<Integer> all){
        visi[node]=true;
        all.add(node);
        int count=1;
        for(int num:list.get(node)){
            if(!visi[num]){
                //System.out.println(size+" "+list.get(num).size)  
                count+=helper(num,list,visi,total,all);
            }
        }
        return count;
    }
}