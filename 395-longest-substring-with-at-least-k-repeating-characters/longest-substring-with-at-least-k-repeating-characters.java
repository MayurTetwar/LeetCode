class Solution {
    public int longestSubstring(String s, int k) {
        int n=s.length();
        int[] count=new int[26];
        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        for(int i=0;i<n;i++){
            if(count[s.charAt(i)-'a']<k){
                int left=longestSubstring(s.substring(0,i),k);
                int right=longestSubstring(s.substring(i+1,n),k);
                return Math.max(left,right);
            }
        }
        return n;
    }
}