class Solution {
    public int sortableIntegers(int[] arr) {
        int n=arr.length;

        List<Integer> list=getDivisors(n);
        // if(helper(arr,n,1)){
        //     int ans=0;
        //     for(int k:list){
        //         ans+=k;
        //     }
        //     return ans;
        // }
        int ans=0;
        for(int k:list){
            if(helper(arr,n,k)){
                ans+=k;
            }
        }
        return ans;
    }
    public boolean helper(int[] arr,int n,int k){
        int max=0;
        for(int i=0;i<n;i+=k){
            int count=0;
            int min=arr[i+k-1];
            int max2=arr[i+k-1];
            if(arr[i+k-1]>arr[i])count++;
            for(int j=i;j<i+k-1;j++){
                if(arr[j]>arr[j+1])count++;
                max2=Math.max(arr[j],max2);
                min=Math.min(arr[j],min);
            }
            if(count>1 || max>min)return false;
            max=max2;
        }
        return true;
    }
    public List<Integer> getDivisors(int x) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                divisors.add(i);
                if (i != x / i) {
                    divisors.add(x / i);
                }
            }
        }
        return divisors;
    }

}
