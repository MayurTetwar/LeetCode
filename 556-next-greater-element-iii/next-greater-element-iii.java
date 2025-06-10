class Solution {
    public int nextGreaterElement(int n) {
        String str=String.valueOf(n);
        n=str.length();
        int[] arr=new int[n];
        int ind=-1;
        arr[n-1]=str.charAt(n-1)-'0';
        for(int i=n-2;i>=0;i--){
            arr[i]=str.charAt(i)-'0';
            if(ind==-1 && arr[i]<arr[i+1])ind=i;
        }
        //System.out.println(ind);
        if(ind==-1)return -1;
        int ind2=-1;
        int next=10;
        for(int j=ind+1;j<n;j++){
            if(arr[ind]<arr[j] && arr[j]<next){
                next=arr[j];
                ind2=j;
            }
        }
        //System.out.println(ind2);
        if(ind2==-1)return -1;
        int temp=arr[ind];
        arr[ind]=arr[ind2];
        arr[ind2]=temp;
        Arrays.sort(arr,ind+1,n);
        long ans=0;
        for(int i=0;i<n;i++){
            ans+=arr[i];
            ans*=10;
        }
        ans/=10;
        if(ans>Integer.MAX_VALUE)return -1;
        return (int)ans;
    }
    // public int helper(String str,int num){

    // }
}