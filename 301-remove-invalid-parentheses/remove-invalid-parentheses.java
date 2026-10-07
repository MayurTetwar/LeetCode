class Solution {
    int rem;
    HashSet<String> ans;
    // boolean[][][][] memo;
    public List<String> removeInvalidParentheses(String s) {
        int count=0;
        ans=new HashSet<>();
        Stack<Integer> stk=new Stack<>();
        int n=s.length();
        // memo=new boolean[n][(1<<n)][n][n];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                stk.add(i);
                continue;
            }
            if(s.charAt(i)!=')')continue;
            if(!stk.isEmpty() && s.charAt(stk.peek())=='(')stk.pop();
            else stk.add(i);
        }
        rem=stk.size();
        // System.out.println(rem);
        helper(s,0,0,0,0);
        List<String> res=new ArrayList<>();
        for(String str:ans){
            res.add(str);
        }
        return res;
    }
    public void helper(String s,int i,int mask,int count,int n){
        int len=s.length();
        if(i==len && count==0 && rem==n){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<len;j++){
                if((mask&(1<<j))!=0){
                    sb.append(s.charAt(j));
                }
            }
            ans.add(sb.toString());
            return;
        }
        if(i==len)return;
        // if(memo[i][mask][count][n])return;
        int newcount=count;
        if(s.charAt(i)=='(')newcount++;
        else if(s.charAt(i)==')')newcount--;
        helper(s,i+1,mask,count,n+1);
        if(newcount<0)return;
        helper(s,i+1,mask|(1<<i),newcount,n);
        // memo[i][mask][count][n]=true;
    }
}