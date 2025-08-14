class Solution {
    public String largestGoodInteger(String num) {
        int max=-1;
        int n=num.length();
        for(int i=1;i<n-1;i++){
            if(num.charAt(i-1)==num.charAt(i) && num.charAt(i+1)==num.charAt(i)){
                max=Math.max(max,num.charAt(i)-'0');
            }
        }
        if(max==-1)return "";
        return new StringBuilder().append(max).append(max).append(max).toString();
    }
}