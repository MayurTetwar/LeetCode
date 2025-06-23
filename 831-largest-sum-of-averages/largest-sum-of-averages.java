class Solution {
    double[][] memo;
    public double largestSumOfAverages(int[] arr, int k) {
        int n=arr.length;
        if(n==1)return arr[0];
        for(int i=1;i<n;i++){
            arr[i]=arr[i-1]+arr[i];
        }
        memo=new double[n][k+1];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i],-1.0);
        }
        return helper(arr,0,k);
    }
    public double helper(int[] arr,int j,int k){
        int n=arr.length;
        if(k==1){
            // System.out.println(((arr[n-1]-arr[j-1])*1.0/(n-j))+" k");        
            if(j==0){
                return arr[n-1]*1.0/(n);
            }
            return (arr[n-1]-arr[j-1])*1.0/(n-j);
        }
        if(memo[j][k]!=-1.0)return memo[j][k];
        double max=0;
        for(int i=j;i<n-1 && k<=n-i;i++){
            double next=helper(arr,i+1,k-1);
            if((i-j+1)>0 && j>0){
                // System.out.println(i+" "+j+" "+(i-j+1)+" "+((arr[i]-arr[j-1])*1.0/(i-j+1)));
                max=Math.max(next+((arr[i]-arr[j-1])*1.0/(i-j+1)),max);
            }else{
                // System.out.println((arr[i]*1.0/(i+1))+" akela ");
                max=Math.max(next+(arr[i]*1.0/(i+1)),max);
            }
        }
        //  System.out.println(max);
        return memo[j][k]=max;
    }
}