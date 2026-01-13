class Solution {
    public double separateSquares(int[][] arr) {
        double st=0;
        double eps = 1e-5;
        double total=0;
        double end=0;
        for(int[] a:arr){
            total+=(double)a[2]*a[2];
            end=Math.max(end,(double)a[1]+a[2]);
        }
        while(Math.abs(end-st)>eps){
            double mid=(end+st)/2.0;
            boolean ans=helper(arr,mid,total);
            if(!ans){
                st=mid;
            }else{
                end=mid;
            }
        }
        return end;
    }
    public boolean helper(int[][] arr,double mid,double total){
        double area=0;
        for(int[] a:arr){
            if(a[1]<mid){
                area+=(double)a[2]*Math.min(mid-a[1],(double)a[2]);
            }
        }
        // System.out.println(upper+" "+lower);
        return area>=total/2;
    }
}