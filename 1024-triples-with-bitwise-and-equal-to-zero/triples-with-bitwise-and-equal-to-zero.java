class Solution {
    public int countTriplets(int[] arr) {
        int[] map=new int[1<<16];
        for(int num:arr){
            for(int num2:arr){
                map[num&num2]++;
            }
        }
        int ans=0;
        for(int i=0;i<map.length;i++){
            if(map[i]==0)continue;
            for(int num:arr){
                if((num&i)==0){
                    ans+=map[i];
                }
            }
        }
        return ans;
    }
}