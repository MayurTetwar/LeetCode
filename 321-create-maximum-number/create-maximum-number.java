class Solution {
    public int[] maxNumber(int[] arr1, int[] arr2, int k) {
        int[] ans=new int[k];
        // int n=arr.length;
        int min=Math.max(0,k-arr2.length);
        int max=Math.min(k,arr1.length);
        for(int i=min;i<=max;i++){
            int[] a1=getLMS(arr1,i);
            int[] a2=getLMS(arr2,k-i);
            // System.out.println(Arrays.toString(a1));
            // System.out.println(Arrays.toString(a2));
            
            int j=0;
            int p=0;
            int r=0;
            int[] curr=new int[k];
            while(j<i && p<k-i){
                if(helper(a1,j,i,a2,p,k-i)){
                    curr[r++]=a1[j++];
                }else{
                    curr[r++]=a2[p++];
                }
            }
            while(j<i)curr[r++]=a1[j++];
            while(p<k-i)curr[r++]=a2[p++];
            if(helper(curr,0,k,ans,0,k)){
                ans=curr.clone();
            }
        }
        return ans;
    }
    public boolean helper(int[] a1,int i,int n,int[] a2,int j,int m){
        while(i<n && j<m && a1[i]==a2[j]){
            i++;
            j++;
        }
        if(i==n)return false;
        if(j==m)return true;
        return a1[i]>a2[j];
    }
    public int[] getLMS(int[] arr,int k){
        int[] ans=new int[k];
        int n=arr.length;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && arr[i]>stk.peek() && stk.size()-1+(n-i)>=k){
                stk.pop();
            }
            if(stk.size()<k){
                stk.add(arr[i]);
            }
        }
        for(int i=k-1;i>=0;i--){
            ans[i]=stk.pop();
        }
        return ans;
    }
}