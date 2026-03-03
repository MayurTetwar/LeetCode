class Solution {
    public char findKthBit(int n, int k) {

        if (k == 1)
            return '0';

        String s=fun("0",1,n,k);
       return s.charAt(k-1);
    }

    static String fun(String s, int i, int n,int k) {
    
    if(i==n||s.length()>k){
        return s;
    }

      String revS = new String(revInv(0,s.length()-1,s.toCharArray()));
      StringBuilder str=new StringBuilder();
      str.append(s);
      str.append("1");
      str.append(revS);
      return fun(str.toString(),i+1,n,k);
    }

    static char[] revInv(int i, int n, char[] ch) {
        if (i > n)
            return ch;
        if (ch[i] == ch[n]) {
            ch[i] = (ch[i] == '0') ? '1' : '0';
            ch[n] = ch[i];
        }
        return revInv(i + 1, n - 1, ch);
    }
}