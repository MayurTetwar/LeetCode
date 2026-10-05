class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stk=new Stack<>();
        int ans=0;
        boolean flag=true;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stk.push(ans);
                ans=0;
            }else{
                ans=stk.pop()+Math.max(2*ans,1);
            }
        } 
        return ans;
    }
}