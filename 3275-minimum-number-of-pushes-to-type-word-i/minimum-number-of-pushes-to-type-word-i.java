class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int ans=0;
        int i=1;
        while(n>0){
            ans+=Math.min(8,n)*i;
            i++;
            n-=8;
        }
        return ans;
    }
}