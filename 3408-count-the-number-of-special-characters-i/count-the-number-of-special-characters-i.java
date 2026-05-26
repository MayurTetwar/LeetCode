class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] up=new boolean[26];
        boolean[] low=new boolean[26];
        for(char ch:word.toCharArray()){
            if(ch>='a' && ch<='z')low[ch-'a']=true;
            else up[ch-'A']=true;
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(up[i] && low[i])ans++;
        }
        return ans;
    }
}