class Solution {
    public int maximumGain(String s, int x, int y) {
        return Math.max(helper(s,x,y,'a','b'),helper(s,y,x,'b','a'));
    }
    public int helper(String s, int x, int y,char ch1,char ch2){
        Stack<Integer> stk=new Stack<>();
        int n=s.length();
        boolean[] visi=new boolean[n];
        int res1=0;
        for(int i=0;i<n;i++){
            if(!stk.isEmpty() && s.charAt(stk.peek())==ch1 && s.charAt(i)==ch2){
                res1+=x;
                visi[stk.pop()]=true;
                visi[i]=true;
            }else stk.push(i);
        }
        stk=new Stack<>();
        for(int i=0;i<n;i++){
            if(visi[i])continue;
            if(!stk.isEmpty() && s.charAt(stk.peek())==ch2 && s.charAt(i)==ch1){
                res1+=y;
                stk.pop();
            }else stk.push(i);
        }
        return res1;
    }
}