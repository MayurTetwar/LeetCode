class Solution {
    public int numberOfSpecialChars(String word) {
        int[] visi=new int[26];
        int[] low=new int[26];
        // Arrays.fill(visi,true);
        for(char ch:word.toCharArray()){
            if(ch>='A' && ch<='Z'){
                if(visi[ch-'A']==0){
                    if(low[ch-'A']>0)visi[ch-'A']++;
                    else visi[ch-'A']=-(int)1e9;
                }
            }else{
                if(visi[ch-'a']>0){
                    visi[ch-'a']=-(int)1e9;
                }else{
                    low[ch-'a']++;
                }
            }
        }
        int ans=0;
        for(int i=0;i<26;i++){
            if(visi[i]>0)ans++;
        }
        return ans;
    }
}