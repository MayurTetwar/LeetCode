class Solution {
    public int numSteps(String s) {
        int n=s.length();
        char[] ch=s.toCharArray();
        int carry=0;
        int count=0;
        for(int i=n-1;i>=1;i--){
            if(ch[i]=='1'){
                if(carry==1){
                    
                }else{
                    count++;
                    carry=1;
                }
            }else if(carry==1){
                count++;
                carry=1;
            }
        }
        return count+n-1+carry;
    }
}