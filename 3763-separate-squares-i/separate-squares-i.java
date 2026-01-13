class Solution {
    public double separateSquares(int[][] arr) {
        double st=0;
        double end=1000000000001.0;
        double mid=-1;
        double eps = 1e-5;
        while(Math.abs(end-st)>eps){
            mid=((end-st)/2.0)+st;
            double ans=helper(arr,mid);
            if(ans<0){
                st=mid;
            }else{
                end=mid;
            }
        }
        return st;
    }
    public double helper(int[][] arr,double mid){
        double lower =0;
        double upper =0;
        for(int[] a:arr){
            if(a[1]<=mid && mid<=a[1]+a[2]){
                lower+=(double)(a[1]+a[2]-mid)*a[2];
                upper+=(double)(mid-a[1])*a[2];
            }else if(mid<=a[1]){
                lower+=(double)a[2]*a[2];
            }else if(mid>=a[1]+a[2]){
                upper+=(double)a[2]*a[2];
            }
        }
        // System.out.println(upper+" "+lower);
        return upper-lower;
    }
}