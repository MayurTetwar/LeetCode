class Solution {
    public int numRabbits(int[] arr) {
        int[] count=new int[1002];
        int[] visi=new int[1002];
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int i=0;i<n;i++){
            if(visi[arr[i]]==0){
                if(arr[i]==0){
                    ans+=count[arr[i]];
                }else if(count[arr[i]]==arr[i]+1){
                    ans+=count[arr[i]];
                }else if(count[arr[i]]>arr[i]+1){
                    ans+=(count[arr[i]]/(arr[i]+1))*(arr[i]+1);
                    count[arr[i]]=(count[arr[i]]%(arr[i]+1));
                    if(count[arr[i]]>0)ans+=arr[i]+1;
                }else{
                    ans+=arr[i]+1;
                }
                //System.out.println(ans);
                visi[arr[i]]=1;
            }
        }
       // 7 > 3
        return ans;
    }
}