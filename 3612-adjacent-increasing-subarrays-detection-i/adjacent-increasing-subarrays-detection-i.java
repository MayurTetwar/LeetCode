class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> list, int k) {
        int i=1;
        int n=list.size();
        int max=1;
        int prev=1;
        while(i<n){
            if(list.get(i-1)>=list.get(i)){
                prev=max;
                max=0;
            }
            max++;
            i++;
            if((prev>=k && max>=k) || (max>=k*2))return true;
        }
        return false;
    }
}