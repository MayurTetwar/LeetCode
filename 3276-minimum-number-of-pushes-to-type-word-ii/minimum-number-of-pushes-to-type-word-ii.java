class Solution {
    public int minimumPushes(String word) {
        int[] count=new int[26];
        for(char ch:word.toCharArray()){
            count[ch-'a']++;
        }
        Arrays.sort(count);
        int level=0;
        int ans=0;
        int j=0;
        for(int i=25;i>=0;i--){
            if(j%8==0)level++;
            // System.out.println(level+" "+count[i]);
            ans+=(level*count[i]);
            j++;
        }
        return ans;
    }
}