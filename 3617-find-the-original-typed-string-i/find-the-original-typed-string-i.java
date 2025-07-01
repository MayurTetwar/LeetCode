class Solution {
    public int possibleStringCount(String s) {
        int ans=1;
        int n=s.length();
        if(n==1)return ans;
        for(int i=0;i<n;){
            int j=i;
            while(j<n-1 && s.charAt(j)==s.charAt(j+1)){
                j++;
            }
            ans+=(j-i);
            i=j+1;
        }
        return ans;
    }
}