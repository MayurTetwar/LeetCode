class Solution {
    public int maxIncreasingSubarrays(List<Integer> list) {
        int n=list.size();
        int max=0;
        int j=0;
        int prev=1;
        for(int i=1;i<n;i++){
            if(list.get(i-1)>=list.get(i)){
                int len=i-j;
                max=Math.max(max,Math.min(prev,len));
                max=Math.max(max,prev/2);
                prev=len;
                j=i;
            }
        }
        int len=n-j;
        max=Math.max(max,Math.min(prev,len));
        max=Math.max(max,Math.max(prev/2,len/2));
        return max;
    }
}