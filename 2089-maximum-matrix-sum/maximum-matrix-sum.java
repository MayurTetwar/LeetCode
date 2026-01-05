class Solution {
    public long maxMatrixSum(int[][] arr) {
        long sum=0;
        int count=0;
        int max=-1000001;
        int min=1000001;
        for(int[] ar:arr){
            for(int a:ar){
                if(a<=0){
                    max=Math.max(max,a);
                    count++;
                }else{
                    min=Math.min(min,a);
                }
                sum+=Math.abs(a);
            }
        }
        if(count%2==1)return Math.max(sum+max*2,sum-min*2);
        return sum;
    }
}