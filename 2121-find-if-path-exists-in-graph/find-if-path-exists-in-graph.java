class Solution {
    public boolean validPath(int n, int[][] arr, int source, int destination) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++)list.add(new ArrayList<>());
        for(int[] a:arr){
            list.get(a[0]).add(a[1]);
            list.get(a[1]).add(a[0]);
        }
        HashSet<Integer> set=new HashSet<>();

        set.add(source);
        helper(list,source,set);
        
        return set.contains(destination);
    }
    public void helper(List<List<Integer>> list,int curr,HashSet<Integer> set){ 
        // System.out.println(curr);
        List<Integer> bande=list.get(curr);

        for(int num:bande){
            if(!set.contains(num)){
                set.add(num);
                helper(list,num,set);
            }
        }
    }
}