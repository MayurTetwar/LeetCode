class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return helper(finish,limit,s)-helper(start-1,limit,s);
    }
    public long helper(long last,int limit,String s){
        String x=String.valueOf(last);
        if(x.length()<s.length()){
            return 0;
        }
        if(x.length()==s.length()){
            return x.compareTo(s)>=0?1:0;
        }
        int len=x.length()-s.length();
        String suff=x.substring(len);
        long count=0;
        for(int i=0;i<len;i++){
            int curr=x.charAt(i)-'0';
            if(limit<curr){
                count+=(long)Math.pow(limit+1,len-i);
                return count;
            }
            count+=(long)(curr)*(long)Math.pow(limit+1,len-1-i);
        }
        if(suff.compareTo(s)>=0){
            count++;
        }
        return count;
    }
    /*
        8+1+1
        8*(2)+3
        152
        128
        024
    */
}