class Solution {
    int rem;
    HashSet<String> ans;
    public List<String> removeInvalidParentheses(String s) {
        int count=0;
        ans=new HashSet<>();
        helper(s,0,0,0);
        int max=0;
        for(String str:ans){
            max=Math.max(max,str.length());
        }
        List<String> res=new ArrayList<>();
        for(String str:ans){
            if(max==str.length())
                res.add(str);
        }
        return res;
    }
    public void helper(String s,int i,int mask,int count){
        int len=s.length();
        if(i==len){
            if(count>0)return;
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<len;j++){
                if((mask&(1<<j))!=0){
                    sb.append(s.charAt(j));
                }
            }
            ans.add(sb.toString());
            return;
        }
        int newcount=count;
        if(s.charAt(i)=='(')newcount++;
        else if(s.charAt(i)==')')newcount--;
        helper(s,i+1,mask,count);
        if(newcount<0)return;
        helper(s,i+1,mask|(1<<i),newcount);
    }
}