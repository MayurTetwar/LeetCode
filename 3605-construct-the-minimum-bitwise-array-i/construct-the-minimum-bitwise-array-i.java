class Solution {
    public int[] minBitwiseArray(List<Integer> list) {
        int[] cash=new int[1001];
        int n=list.size();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        cash[2]=-1;
        for(int i=0;i<n;i++){
            int num=list.get(i);
            if(cash[num]!=0){
                ans[i]=cash[num];
                continue;
            }
            int val=1;
            while(val<num){
                if((val|(val+1))==num){
                    ans[i]=val;
                    cash[num]=val;
                    break;
                }
                val++;
            }
        }
        return ans;
    }   
}