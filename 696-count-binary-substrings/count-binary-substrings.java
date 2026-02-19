class Solution {
    public int countBinarySubstrings(String s) {
        int i=0;
        int n=s.length();
        int ans=0;
        int last=0;
        while(i<n){
            int j=i;
            int val=s.charAt(i);
            while(i<n && val==s.charAt(i)){
                i++;
            }
            ans+=Math.min(last,i-j);
            last=i-j;
        }
        return ans;
    }
}