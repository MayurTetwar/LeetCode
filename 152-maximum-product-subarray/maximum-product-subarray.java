class Solution {
    public int maxProduct(int[] arr) {
        int max=-1000000;
        int pro=1;
        for(int num:arr){
            pro*=num;
            max=Math.max(max,pro);
            if(pro==0)pro=1;
        }
        pro=1;
        for(int i=arr.length-1;i>=0;i--){
            pro*=arr[i];
            max=Math.max(max,pro);
            if(pro==0)pro=1;
        }
        return max;
    }
}