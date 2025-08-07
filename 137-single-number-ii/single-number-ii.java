class Solution {
    public int singleNumber(int[] arr) {
        int ans=0;
        for(int i=0;i<=31;i++){
            int count=0;
            for(int num:arr){
                if((num&(1<<i))!=0)count++;
            }
            if(count%3==1){
                ans=ans|(1<<i);
            }
        }
        return ans;
    }
}