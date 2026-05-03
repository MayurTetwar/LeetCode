class Solution {
    public boolean rotateString(String s, String goal) {
        
        // int n=s.length();
        // int k=goal.length();
        // if(n!=k)return false;
        // StringBuilder str=new StringBuilder();
        // for(int i=0;i<n;i++){
        //     str.append(s.substring(i,n));
        //     str.append(s.substring(0,i));
        //     if(str.toString().equals(goal)) return true;
        //     str.delete(0,n);
        // }
        // return false;
        if(s.length()!=goal.length())return false;
        s=s+s;
        if(s.contains(goal))return true;
        return false;
    }
}