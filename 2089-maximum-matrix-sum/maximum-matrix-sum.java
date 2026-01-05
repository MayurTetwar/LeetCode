class Solution {
    public long maxMatrixSum(int[][] arr) {
        long sum=0;
        int count=0;
        int min=1000001;
        for(int[] ar:arr){
            for(int a:ar){
                if(a<0)count++;
                min=Math.min(min,Math.abs(a));
                sum+=Math.abs(a);
            }
        }
        if(count%2==1)return sum-min*2;
        return sum;
    }
}