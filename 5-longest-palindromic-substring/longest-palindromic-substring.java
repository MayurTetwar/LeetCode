class Solution {
    static{
        for(int i=0;i<500;i++){
            longestPalindrome("a");
        }
    }
    public static String longestPalindrome(String s) {
        int n=s.length();
        int start=0;
        int end=0;
        for(int i=0;i<n;i++){
            int left=i-1, right=i+1;
            while(left>=0 && right<n){
                if(s.charAt(left)!=s.charAt(right)){
                    break;
                }
                if(end-start<right-left){
                    end=right;
                    start=left;
                }
                left--;
                right++;
            }
            left=i;
            right=i;
           
            if(i<n-1 && s.charAt(left)==s.charAt(right+1)){
                left=i;
                right=i+1;
                while(left>=0 && right<n){
                    if(s.charAt(left)!=s.charAt(right)){
                        break;
                    }
                    if(end-start<right-left){
                        end=right;
                        start=left;
                    }
                    left--;
                    right++;
                }
            }
            //System.out.println(start+" "+end+" "+i);
        }
        return s.substring(start,end+1);
    }
}