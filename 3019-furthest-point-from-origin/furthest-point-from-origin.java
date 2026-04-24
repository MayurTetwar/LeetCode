class Solution {
    public int furthestDistanceFromOrigin(String s) {
        int r=0;
        int l=0;
        int c=0;
        for(char ch:s.toCharArray()){
            if(ch=='R')r++;
            else if(ch=='L')l++;
            else c++;
        }
        return Math.abs(r-l)+c;
    }
}