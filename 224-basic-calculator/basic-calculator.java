class Solution {
    int i;
    public int calculate(String s) {
        i=0;
        return helper(s);
    }
    public int helper(String s){
        int res=0,sign=1,num=0;;
        while(i<s.length()){
            char ch=s.charAt(i++);
            if(ch>='0' && ch<='9')num=num*10+(ch-'0');
            else if(ch=='(')num=helper(s);
            else if(ch==')')return res+sign*num;
            else if(ch=='+' || ch=='-'){
                res+=sign*num;
                num=0;
                sign=(ch=='+')?1:-1;
            }
        }
        return res+sign*num;
    }
}