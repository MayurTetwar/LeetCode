class Solution {
    public boolean divideArray(int[] arr) {
        int n=arr.length;
        boolean[] visi=new boolean[1001];
        boolean ans=false;
        int count=0;
        for(int i=0;i<n;i++){
            if(visi[arr[i]]){
                visi[arr[i]]=false;
                count--;
            }else{
                visi[arr[i]]=true;
                count++;
            }
        }
        return count==0;
    }
}