class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        StringBuilder s=new StringBuilder();
        for(int i=0;i<n-1;i++){
            s.append(".");
        }
        helper(ans,0,n,new HashSet<>(),new HashSet<>(),new HashSet<>(),s,new ArrayList<>());
        return ans;
    }
    public void helper(List<List<String>> ans,int i,int n,HashSet<Integer> set,HashSet<Integer> s1,HashSet<Integer> s2,StringBuilder s,List<Integer> l){
       // System.out.println(set+" "+s1+" "+s2);
        if(n==i){
            int k=0;
            List<String> list=new ArrayList<>();
            for(int num:l){
                StringBuilder str=new StringBuilder(s);
                str.insert(num,"Q");
                list.add(str.toString());
            }
            ans.add(list);
            return;
        }
        for(int j=0;j<n;j++){
            if(s2.contains(j))continue;
            if(!set.contains(j-i) && !s1.contains(j+i)){
                set.add(j-i);
                s1.add(j+i);
                s2.add(j);
                l.add(j);
                helper(ans,i+1,n,set,s1,s2,s,l);
                set.remove(j-i);
                s1.remove(j+i);
                s2.remove(j);
                l.remove(l.size()-1);
            }
        }
        return ;
    }

}