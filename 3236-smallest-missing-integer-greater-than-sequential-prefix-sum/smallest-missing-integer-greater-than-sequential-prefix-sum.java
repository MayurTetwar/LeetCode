class Solution {
    public int missingInteger(int[] arr) {
        boolean[] visi=new boolean[51];
        int n=arr.length;
        int sum=arr[0];
        for(int i=0;i<n-1;i++){
            if(arr[i]+1==arr[i+1]){
                sum+=arr[i+1];
            }else{
                break;
            }
        }
        for(int num:arr){
            visi[num]=true;
        }
        while(sum<51 && visi[sum])sum++;
        return sum;
    }
}