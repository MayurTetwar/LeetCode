class Solution {
    public int minOperations(int[][] arr, int x) {
        int n=arr.length;
        int m=arr[0].length;

        int[] sort=new int[n*m];
        int k=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sort[k++]=arr[i][j];
            }
        }
        Arrays.sort(sort);
        int mid=0;
        if(n*m%2==0){
            mid=(n*m+1)/2;
        }else{
            mid=n*m/2;
        }
       // System.out.println(sort[mid]);
        int ans=0;
        for(int i=0;i<n*m;i++){
            int val=Math.abs(sort[mid]-sort[i]);
            if(val%x!=0){
                return -1;
            }
           // System.out.println(sort[i]+" "+x);
            ans+=val/x;
        }
        return ans;
    }
}