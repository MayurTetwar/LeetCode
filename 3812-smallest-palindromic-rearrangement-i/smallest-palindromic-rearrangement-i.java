class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int[] count=new int[26];
        for(int i=0;i<n/2;i++){
            count[s.charAt(i)-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<26;i++){
            int val=count[i];
            while(val-->0)sb.append((char)('a'+i));
        }
        if(n%2==1){
            sb.append(s.charAt(n/2));
        }
        for(int i=25;i>=0;i--){
            int val=count[i];
            while(val-->0)sb.append((char)('a'+i));
        }
        return sb.toString();
    }
}