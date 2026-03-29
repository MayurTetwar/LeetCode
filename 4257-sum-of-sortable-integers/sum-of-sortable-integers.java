class Solution {
    public int sortableIntegers(int[] arr) {
        int n=arr.length;
        int ans=0;
        boolean flag=true;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                flag=false;
                break;
            }
        }
        if(flag)ans++;
        for(int i=2;i<=n;i++){
            if(n%i==0){
                if(helper(arr,i)){
                    ans+=i;
                }
            }
        }
        return ans;
    }
    public boolean helper(int[] a,int len){
        int n=a.length;
        int[] arr=a.clone();
        for(int i=0;i<n;i+=len){
            int minj=-1;
            for(int j=i;j<i+len-1;j++){
                if(arr[j]>arr[j+1]){
                    minj=j+1;
                    break;
                }
            }
            if(minj==-1){
                continue;
            }
            int prev=arr[minj];
            for(int j=i;j<i+len-1;j++){
                minj++;
                if(minj==i+len){
                    minj=i;
                }
                // System.out.println(prev+" "+arr[minj]);
                if(prev>arr[minj]){
                    return false;
                }
                prev=arr[minj];
            }
            Arrays.sort(arr,i,i+len);
        }
        // System.out.println(len);
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1])return false;
        }
        return true;
    }
}