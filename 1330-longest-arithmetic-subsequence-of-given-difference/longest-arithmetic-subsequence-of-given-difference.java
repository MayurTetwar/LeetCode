class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
          //  if(map.containsKey(arr[i]-diff)){
                map.put(arr[i],map.getOrDefault(arr[i]-diff,0)+1);
            // }else{

            // }
        }
        int max=0;
        for(int len:map.values()){
            max=Math.max(max,len);
        }
        return max;
    }
}