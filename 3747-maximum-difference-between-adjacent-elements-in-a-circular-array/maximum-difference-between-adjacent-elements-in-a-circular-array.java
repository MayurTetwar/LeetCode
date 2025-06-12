class Solution {
    public int maxAdjacentDistance(int[] arr) {
        int max=0;
        for(int i=0;i<arr.length-1;i++){
            int num=Math.abs(arr[i]-arr[i+1]);
            if(max<num){
                max=num;
            }
        }
        return Math.max(max,Math.abs(arr[0]-arr[arr.length-1]));
    }
}