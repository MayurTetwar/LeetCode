class Solution {
    public boolean checkStrings(String s1, String s2) {
        int[] f1e=new int[27];
        int[] f2e=new int[27];
        int[] f1o=new int[27];
        int[] f2o=new int[27];
        int n=s1.length();
        for(int i=0;i<n;i++){
            if(i%2==0)f1e[s1.charAt(i)-'a']++;
            else f1o[s1.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            if(i%2==0)f2e[s2.charAt(i)-'a']++;
            else f2o[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<27;i++){
            if(f1e[i]!=f2e[i])return false;
            if(f1o[i]!=f2o[i])return false;
        }
        return true;
    }
}