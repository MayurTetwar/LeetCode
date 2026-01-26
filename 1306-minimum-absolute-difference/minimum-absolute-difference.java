class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=0;i<n-1;i++){
            min=Math.min(min,arr[i+1]-arr[i]);
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            if(min==arr[i+1]-arr[i]){
                List<Integer> pair=new ArrayList<>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                list.add(pair);
            }
        }
        return list;
    }
}