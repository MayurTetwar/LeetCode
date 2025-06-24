class Solution {
      static {
    for (int i = 0; i < 500; i++) findKDistantIndices(new int[] {1, 1}, 1, 1);
}
    public static List<Integer> findKDistantIndices(int[] arr, int key, int k) {

        int n=arr.length;
        List<Integer> keyInd = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(key==arr[i])keyInd.add(i);
        }
        HashSet<Integer> set=new HashSet<>();
        for(int ind:keyInd){
            set.add(ind);
            int k2=k;
            int k3=k;
            for(int i=ind-1;i>=0 && k3-->0;i--){
                set.add(i);
            }
            for(int i=ind+1;i<n && k2-->0;i++){
                set.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int num:set){
            ans.add(num);
        }
        Collections.sort(ans);
        return ans;
    }
}