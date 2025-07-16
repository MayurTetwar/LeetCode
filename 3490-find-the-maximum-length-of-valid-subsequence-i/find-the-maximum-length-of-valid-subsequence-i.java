class Solution {
    public int maximumLength(int[] arr) {
        int ev=0;
        int odd=0;
        int ans=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]%2==0)ev++;
            else odd++;
        }
        ans=Math.max(ev,odd);
        int ans2=0;
        boolean even=true;
        for(int i=0;i<n;i++){
            if(even){
                if(arr[i]%2!=0){
                    ans2++;
                    even=false;
                }
            }else{
                if(arr[i]%2==0){
                    ans2++;
                    even=true;
                }
            }
        }
        ans=Math.max(ans,ans2);
        ans2=0;
        even=false;
        for(int i=0;i<n;i++){
            if(even){
                if(arr[i]%2!=0){
                    ans2++;
                    even=false;
                }
            }else{
                if(arr[i]%2==0){
                    ans2++;
                    even=true;
                }
            }
        }
        return Math.max(ans,ans2);
    }
}