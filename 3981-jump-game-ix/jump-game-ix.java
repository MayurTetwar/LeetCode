class Solution {
    public int[] maxValue(int[] arr) {
        int n=arr.length;
        int[] pre=new int[n];
        int[] suff=new int[n];
        pre[0]=0;
        int ind=0;
        for(int i=1;i<n;i++){
            if(arr[ind]<arr[i]){
                ind=i;
            }
            pre[i]=ind;
        }
        int[] ans=new int[n];
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i=n-1;i>=0;i--){
            Integer small=tm.lowerKey(arr[i]);
            int val=0;
            if(small!=null){
                ind=pre[tm.get(small)];
                val=arr[pre[ind]];
                Integer ind2=tm.get(val);
                if(ind2!=null && arr[i]!=arr[ind2] && arr[ind]!=arr[ind2]){
                    ind=ind2;
                    val=arr[pre[ind]];
                }
             //  System.out.println(val+" "+ind+" "+i+" "+tm);
                tm.put(arr[i],ind);
            }else{
                if(!tm.containsKey(arr[i]))tm.put(arr[i],i);
            //   System.out.println(arr[pre[i]]+" "+pre[i]+" "+i);
                val=arr[pre[i]];
            }
            if(arr[i]<val){
                ans[i]=val;
            }else{
                ans[i]=arr[i];
            }
        }
     //  System.out.println(Arrays.toString(ans));
        for(int i=0;i<n;i++){
          //  System.out.println(pre[i]);
            ans[i]=Math.max(ans[i],ans[pre[i]]);
        }
        // pre[0]=0;
        // ind=0;
        // for(int i=1;i<n;i++){
        //     if(ans[ind]<ans[i]){
        //         ind=i;
        //     }
        //     pre[i]=ind;
        // }
        // tm=new TreeMap<>();
        // for(int i=n-1;i>=0;i--){
        //     Integer small=tm.lowerKey(arr[i]);
        //     int val=0;
        //     if(small!=null){
        //         ind=tm.get(small);
        //         val=ans[ind];
        //         ans[i]=Math.max(ans[i],val);
        //     }
        //     tm.put(arr[i],ind);
        // }
        // for(int i=0;i<n;i++){
        //   //  System.out.println(pre[i]);
        //     ans[i]=Math.max(ans[i],ans[pre[i]]);
        // }
        return ans;
    }
}