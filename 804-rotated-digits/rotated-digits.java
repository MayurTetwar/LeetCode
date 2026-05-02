class Solution {
    public int rotatedDigits(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            boolean rot=false;
            int val=i;
            while(val>0){
                int dig=val%10;
                if(dig==3 || dig==4 || dig==7){
                    rot=false;
                    break;
                }else if(dig==2 || dig==5 || dig==6 || dig==9){
                    rot=true;
                }
                val/=10;
            }
            if(rot)ans++;
        }
        return ans;
    }
}