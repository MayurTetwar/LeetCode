class Solution {
    public int minOperations(int[] arr, int k) {
        int min=(int)1e9;
        int n=arr.length;
        for(int x=0;x<k;x++){
            for(int y=0;y<k;y++){
                if(x==y)continue;
                int res=0;
                for(int i=0;i<n;i++){
                    if(i%2==0){
                        int val=Math.abs(x-arr[i]%k);
                        res+=Math.min(val,k-val);
                    }else{
                        int val=Math.abs(y-arr[i]%k);
                        res+=Math.min(val,k-val);
                    }
                }
                min=Math.min(min,res);
            }
        }
        return min;
    }
}