class Solution {
    public int characterReplacement(String s, int kt) {
        int max=0;
        int n=s.length();
        for(int i=0;i<26;i++){
            int left=0,right=0;
            int k=kt;
            while(left<n){
                right=Math.max(right,left);
                while(right<n && ((s.charAt(right)-'A')==i || k>0)){
                    if((s.charAt(right)-'A')!=i){
                        k--;
                    }
                    right++;
                }
                max=Math.max(right-left,max);
                if(s.charAt(left)-'A'!=i && k+1<kt)k++;
                left++;
            }
        }
        return max;
    }
}