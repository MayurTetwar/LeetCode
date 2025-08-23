class Solution {
    public String getPermutation(int n, int k) {
        boolean[] arr=new boolean[n+1];
        return helper(arr,k,n);  
    }
    public String helper(boolean[] arr,int k,int len){
        int step=1;
        for(int i=1;i<len;i++)step*=i;
       // int =per
        if(k==1){
            StringBuilder sb=new StringBuilder();
            for(int i=1;i<arr.length;i++){
                if(!arr[i])sb.append(i);
            }
            return sb.toString();
        }
        int ind=1;
        while(arr[ind])ind++;
        while(k-step>0){
            k-=step;
            ind++;

            while(arr[ind]){
               // System.out.println(ind+" "+k);
                ind++;
            }
        }
        arr[ind]=true;
      //  System.out.println(ind+" out "+k);
        return String.valueOf(ind).concat(helper(arr,k,len-1));
    }
}