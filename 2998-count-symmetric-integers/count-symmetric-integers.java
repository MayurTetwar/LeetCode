class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int ans=0;
        for(int i=low;i<=high;i++){
            if(isSamesum(i))ans++;
        }
        return ans;
    }
    public boolean isSamesum(int num){
        if(num>9999 || (num>99 && num<1000) || (num<10))return false;
        if(num>1000){
            //System.out.println((num/1000)+" "+((num/100)%10)+" "+((num/10)%10)+" "+(num%10));
            if(num/1000+((num/100)%10)==((num/10)%10)+num%10){
                return true;
            }
        }else{
            if(num%10==num/10)return true;
        }
        return false;
    }
}