class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                stk.push(ch);
            }else{
                if(stk.size()==0)return false;
                if(ch==')'){
                    if(stk.pop()!='(')return false;
                }else if(ch==']'){
                    if(stk.pop()!='[')return false;
                }else{
                    if(stk.pop()!='{')return false;
                }
            }
        }   
        return stk.size()==0;
    }
}