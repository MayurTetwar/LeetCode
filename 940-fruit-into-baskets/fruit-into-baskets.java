class Solution {
    public int totalFruit(int[] arr) {
        int n=arr.length;
        if(n==1)return 1;
        if(n==2)return 2;
        int ans=0;
        int j=0;
        int k=1;
        while(k<n && arr[j]==arr[k])k++;
        int count=0;
        int min=1;
        for(int i=2;i<n;i++){
            int curr=arr[i];
            if(arr[j]!=curr && arr[k]!=curr){
                if(j<k){
                    j=i;
                    k=min;
                }else{
                    k=i;
                    j=min;
                }
            }
            if(arr[min]!=curr){
                min=i;
            }
            ans=Math.max(ans,i-Math.min(j,k)+1);
            // System.out.println(i+" "+j+" "+k+" "+ans);
        }
        return ans;
    }
}