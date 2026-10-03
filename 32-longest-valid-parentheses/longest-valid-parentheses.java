class Solution {
    public int longestValidParentheses(String s) {
        
        int n=s.length();
        boolean[] isvalid=new boolean[n];
        Stack<Integer> stk=new Stack<>();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i)=='(')stk.push(i);
            else if(!stk.empty()){
                isvalid[stk.pop()]=true;
                isvalid[i]=true;
            }
        }
        int ans=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(!isvalid[i])count=0;
            else{
                count++;
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
}