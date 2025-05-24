class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        int n=s.length();
        ans=new ArrayList<>();
        helper(new ArrayList<>(),s,0);
        return ans;
    }
    public void helper(List<String> list,String s,int i){
        if(i>=s.length()){
            List<String> add=new ArrayList<>();
            for(String str:list){
                add.add(str);
            }
            // //System.out.println(list);
            ans.add(add);
            // //System.out.println(ans);
            return ;
        }
        for(int j=i+1;j<=s.length();j++){
            String sub=s.substring(i,j);
            if(isPoli(sub)){
                list.add(sub);
                //System.out.println(sub+" "+i+" "+j);
                helper(list,s,j);
                list.remove(list.size()-1);
            }
           
        }
    }
    public boolean isPoli(String s){
        StringBuilder sb=new StringBuilder(s);
        sb.reverse();
        if(s.equals(sb.toString()))return true;
        return false;
    }
}