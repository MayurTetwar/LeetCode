class Solution {
    int complete;
    public boolean canFinish(int numCo, int[][] pre) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<numCo;i++){
            list.add(new ArrayList<>());
        }
        int[] visi=new int[numCo];
        Set<Integer> notSt=new HashSet<>();
        for(int[] p:pre){
            list.get(p[1]).add(p[0]);
            visi[p[0]]++;
            notSt.add(p[0]);
        }
        complete=0;
        for(int i=0;i<numCo;i++){
            if(!notSt.contains(i)){
                dfs(list,visi,i);
            }
        }
        return complete==numCo;
    }
    public void dfs(List<List<Integer>> list,int[] visi,int curr){
        complete++;
        System.out.println(curr);
        for(int neg:list.get(curr)){
            visi[neg]--;
            if(visi[neg]==0){
                dfs(list,visi,neg);
            }
        }
    }
}