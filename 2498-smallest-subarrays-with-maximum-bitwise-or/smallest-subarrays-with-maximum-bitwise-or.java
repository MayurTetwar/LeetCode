class Solution {
    public int[] smallestSubarrays(int[] arr) {
        int max=0;
        int n=arr.length;
        for(int num:arr)max=Math.max(max,num);
        int bitlen=Integer.toBinaryString(max).length();
        int[][] bit=new int[bitlen][n+1];
        for(int i=n-1;i>=0;i--){
            String str=Integer.toBinaryString(arr[i]);
            int m=str.length();
            for(int j=m-1;j>=0;j--){
                int val=bit[j+bitlen-m][i+1]+(str.charAt(j)-'0');
                bit[j+bitlen-m][i]=val;
            }
            for(int j=bitlen-m-1;j>=0;j--){
                bit[j][i]=bit[j][i+1];
            }
        }
        // for(int i=0;i<bitlen;i++){
        //     System.out.println(Arrays.toString(bit[i]));
        // }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            int dis=1;
            for(int j=0;j<bitlen;j++){
                int tar=bit[j][i];
                if(tar>0)dis=Math.max(dis,bs(bit[j],i+1,tar)-i);
            }
            ans[i]=dis;
        }
        return ans;
    }
    public int bs(int[] arr,int st,int tar){
        int end=arr.length-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(arr[mid]>=tar){
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return end+1;
    }
    /*
    2 2 2 1 1 0
    3 2 2 2 1 0

    */
}