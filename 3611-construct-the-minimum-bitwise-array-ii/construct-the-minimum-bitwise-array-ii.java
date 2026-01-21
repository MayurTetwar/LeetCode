class Solution {
    public int[] minBitwiseArray(List<Integer> list) {
        int n=list.size();
        int[] ans=new int[n];
        for(int j=0;j<n;j++){
            int num=list.get(j);
            if(num==2){
                ans[j]=-1;
                continue;
            }
            int val=0;
            boolean flag=true;
            for(int i=0;i<32;i++){
                if((num&(1<<i))==0){
                    if(flag){
                        val=val&(~(1<<(i-1)));
                        flag=false;
                    }
                }else{
                    val=val|(1<<i);
                }
            }
            ans[j]=val;
        }
        return ans;
    }
}