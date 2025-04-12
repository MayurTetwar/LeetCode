class Solution {
    public String addBinary(String a, String b) {
        if(a.length()<b.length())return addBinary(b,a);
        int n=a.length()-1;
        int m=b.length()-1;
        boolean carry=false;
        StringBuilder str=new StringBuilder();
        while(n>=0 || m>=0 || carry){
            int sum=0;
            if(n>=0){
                sum+=a.charAt(n--)-'0';
            }
            if(m>=0){
                sum+=b.charAt(m--)-'0';
            }
            if(sum==2){
                if(carry)str.append('1');
                else str.append('0');
                carry=true;
            }else if(sum==1){
                if(carry)str.append('0');
                else str.append('1');
            }else{
                if(carry)str.append('1');
                else str.append('0');
                carry=false;
            }
        }
        return str.reverse().toString();
    }
}