class Solution {
    public int triangleNumber(int[] arr) {
        int n=arr.length;
        int ans=0;
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            if(arr[i]==0)continue;
            int k=i+1;
            for(int j=i+1;j<n;j++){
                int sum=arr[i]+arr[j];
                while(k+1<n && arr[k+1]<sum){
                    k++;
                } 
                if(k<n)ans+=k-j;
                // System.out.println(ans+" "+k);
            }
        }
        return ans;
    }
}