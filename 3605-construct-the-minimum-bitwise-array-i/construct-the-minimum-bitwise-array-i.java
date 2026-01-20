class Solution {
    public int[] minBitwiseArray(List<Integer> list) {
        int n=list.size();
        int[] ans=new int[n];
        Arrays.fill(ans,-1);
        for(int i=0;i<n;i++){
            int num=list.get(i);
            int val=1;
            while(val<num){
                if((val|(val+1))==num){
                    ans[i]=val;
                    break;
                }
                val++;
            }
        }
        return ans;
    }   
}