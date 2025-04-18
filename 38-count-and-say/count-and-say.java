class Solution {
    public String countAndSay(int n) {
        if(n==1)return "1";
        String str=countAndSay(n-1);
        StringBuilder sb=new StringBuilder();
        int strLen=str.length();
        for(int i=0;i<strLen;i++){
            int last=i;
            while(i<strLen-1 && str.charAt(i)==str.charAt(i+1))i++;
            sb.append(i-last+1);
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    /*
     3-> 21
     4-> 1121
     5-> 11121
     6-> 312211
    */
}