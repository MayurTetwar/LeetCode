class Solution {
    public boolean isGood(int[] arr) {
        int n=arr.length-1;
        int[] map=new int[n+1];
        for(int num:arr){
            if(num>n)return false;
            map[num]++; 
        }
        for(int i=1;i<n;i++){
            if(map[i]!=1){
                return false;
            }
        }
        return map[n]==2;
    }
}