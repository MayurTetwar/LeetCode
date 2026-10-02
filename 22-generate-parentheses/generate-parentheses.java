class Solution {

    static void genAll(int open,int close,List<String> list,String s){
      
    if(open==0 && close==0){
            list.add(s);
            return;
      }
        if(open>0)
        genAll(open-1,close,list,s+"(");

        if(open<close){
            genAll(open,close-1,list,s+")");
        }

    }
    public List<String> generateParenthesis(int n) {
        
        List<String> list=new ArrayList<>();
      genAll(n,n,list ,"");
      return list;
    }
}