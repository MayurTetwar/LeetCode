class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int n=s.length();
        int[] ans=new int[n];
        Stack<Integer> stk1=new Stack<>();
        Stack<Integer> stk2=new Stack<>();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                if(stk1.size()<stk2.size()){
                    stk1.push(i);
                    ans[i]=0;
                }else{
                    stk2.push(i);
                    ans[i]=1;
                }
            }else{
                if(stk1.size()>stk2.size()){
                    stk1.pop();
                    ans[i]=0;
                }else{
                    stk2.pop();
                    ans[i]=1;
                }
            }
        }
        return ans;
    }
}