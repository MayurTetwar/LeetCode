class Solution {
    public int minOperations(String s) {
        int n=s.length();
        if(n==2){
            if(s.charAt(0)<=s.charAt(1))return 0;
            return -1;
        }
        char min='z'+1;
        int mini=0;
        char max='a'-1;
        int maxi=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)<min){
                min=s.charAt(i);
                mini=i;
            }
            if(s.charAt(i)>max){
                max=s.charAt(i);
                maxi=i;
            }
        }
        if(s.charAt(mini)==s.charAt(0) && s.charAt(maxi)==s.charAt(n-1)){
            for(int i=0;i<n-1;i++){
                if(s.charAt(i)>s.charAt(i+1))return 1;
            }
            return 0;
        }
        if(s.charAt(mini)==s.charAt(0) || s.charAt(maxi)==s.charAt(n-1)){
            return 1;
        }
        if(s.charAt(mini)==s.charAt(n-1) && s.charAt(maxi)==s.charAt(0)){
            if(s.substring(1,n-1).contains(String.valueOf(s.charAt(mini))) || s.substring(1,n-1).contains(String.valueOf(s.charAt(maxi))))return 2;
            return 3;
        }
        return 2;
    }
}