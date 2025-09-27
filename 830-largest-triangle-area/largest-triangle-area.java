class Solution {
    public double largestTriangleArea(int[][] arr) {
        int n=arr.length;
        double ans=0.0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                for(int k=j+1;k<n;k++){
                    double val1=arr[i][0]*(arr[j][1]-arr[k][1]);
                    double val2=arr[j][0]*(arr[k][1]-arr[i][1]);
                    double val3=arr[k][0]*(arr[i][1]-arr[j][1]);
                    ans=Math.max(ans,0.5*Math.abs(val1+val2+val3));
                }
            }
        }
        return ans;
    }
    // Area=21​​x1​(y2​−y3​)+x2​(y3​−y1​)+x3​(y1​−y2​)
}