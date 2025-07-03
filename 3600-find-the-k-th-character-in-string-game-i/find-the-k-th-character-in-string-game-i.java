class Solution {
    public char kthCharacter(int k) {
        return helper(k,1,"a");
    }
    public char helper(int k,int len,String s){
      //  System.out.println(s);
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<len;i++){
            int next=s.charAt(i)+1;
            next=(next==123)?97:next;
          //  (next);
            sb.append((char)next);
        }
        len*=2;
        if(len>=k){
            return sb.charAt(k-1);
        }
        return helper(k,len,sb.toString());
    }
}