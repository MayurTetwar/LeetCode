class Solution {
    public long countSubarrays(int[] arr, long k) {
        int n = arr.length;
        long prefix[] = new long[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = arr[i] + prefix[i - 1];
        }
        long ans = 0;
        long pre = 0;
        int i = 0;
        int ind = 0;
        int save = 0;
        for (i = 0; i < n; i++) {
            ind = helper(prefix, k, pre, i) - i;
            //System.out.println(save+" "+ind+" "+i+" "+ans);
            // if(ind>save)ans+=(poss(ind)-poss(i-save));
            ans += ind;
            pre = prefix[i];
            // save=ind-1;
            // if(ind<=i)i++;
            // else i=ind;
        }
        // if(i<n){
        //     //System.out.println("Hi");
        //     if(arr[n-1]<k)ans++;
        // }
        return ans;
    }

    public long poss(int num) {
        //System.out.println(((num+1)*num)/2);
        return ((num + 1) * num) / 2;
    }

    public int helper(long[] arr, long k, long pre, int i) {
        // //System.out.println(i+" "+pre);
        int st = i;
        int end = arr.length;
        while (st < end) {
            int mid = (end + st) / 2;
            // //System.out.println(end+" "+st+" "+(arr[mid]-pre)+" "+(mid-i+1));
            if (((arr[mid] - pre) * (mid - i + 1)) < k) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }
        // if(end==arr.length-1)return end+1;
        return end;
    }
}