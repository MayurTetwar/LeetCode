class Solution {
    public int[] recoverArray(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        for(int i=1;i<n;i++){
            int[] res=new int[n/2];
            if(helper(arr,(arr[i]-arr[0])/2,res)){
                return res;
            }
        }
        return arr;
    }
    public boolean helper(int[] arr,int k,int[] res){
        int i=0,j=1;
    //    System.out.println(k);
        int n=arr.length;
        int ind=0;
        boolean[] visi=new boolean[n];
        while(j<n){
            if(visi[i]){
                i++;
                continue;
            }
            if(visi[j]){
                j++;
                continue;
            }
            int diff=arr[j]-arr[i];
            if(diff>2*k){
                i++;
            }else if(diff<2*k){
                j++;
            }else{
                visi[i]=true;
                visi[j]=true;
                if(ind==res.length)return false;
                res[ind++]=arr[i]+k;
                i++;
                j++;
            }
        }
        if(ind==res.length)return true;
        return false;
    } 
}