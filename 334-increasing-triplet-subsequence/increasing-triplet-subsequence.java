class Solution {
    public boolean increasingTriplet(int[] arr) {
        TreeSet<Integer> ts=new TreeSet<>();
        int n=arr.length;
        Integer[] left=new Integer[n];
        for(int i=0;i<n;i++){
            if(ts.lower(arr[i])!=null){
                left[i]=ts.lower(arr[i]);
            }else{
                left[i]=Integer.MAX_VALUE;
            }
            ts.add(arr[i]);
        }
        ts=new TreeSet<>();
        Integer[] right=new Integer[n];
        for(int i=n-1;i>=0;i--){
            if(ts.higher(arr[i])!=null){
                right[i]=ts.higher(arr[i]);
            }else{
                right[i]=Integer.MIN_VALUE;
            }
            ts.add(arr[i]);
        }
        //System.out.println(Arrays.toString(left));
        //System.out.println(Arrays.toString(right));
        for(int i=0;i<n;i++){
            if(left[i]!=null && right[i]!=null){
                if(left[i]<arr[i] && arr[i]<right[i]){
                    return true;
                }
            }
        }
        return false;
    }
}