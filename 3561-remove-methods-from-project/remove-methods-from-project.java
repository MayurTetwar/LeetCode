class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] arr) {
        boolean[] visi=new boolean[n];

        List<List<Integer>> list=new ArrayList<>(); 
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        for(int[] a:arr){
            list.get(a[0]).add(a[1]);
        }
        helper(list,k,visi);
        boolean flag=false;
        for(int[] a:arr){
            if(!visi[a[0]] && visi[a[1]]){
                flag=true;
                break;
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(flag || !visi[i])ans.add(i);
        }
        return ans;
    }
    public void helper(List<List<Integer>> list,int curr,boolean[] visi){
        visi[curr]=true;
        for(int neg:list.get(curr)){
            if(!visi[neg]){
                helper(list,neg,visi);
            }
        }
    }
}