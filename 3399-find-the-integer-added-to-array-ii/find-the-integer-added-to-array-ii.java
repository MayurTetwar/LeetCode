class Solution {
    public int minimumAddedInteger(int[] arr, int[] arr2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=arr.length;
        int m=arr2.length;
        for(int i=0;i<m;i++){
            map.put(arr2[i],map.getOrDefault(arr2[i],0)+1);
        }
        for(int i=-1000;i<1000;i++){
            if(helper(i,map,arr,m))return i;
        }
        return 0;
    }
    public boolean helper(int mid,HashMap<Integer,Integer> map2,int[] arr,int limit){
        int count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.putAll(map2);
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i]+mid) && map.get(arr[i]+mid)>0){
                count++;
                map.put(arr[i]+mid,map.get(arr[i]+mid)-1);
            }
        }
        if(count==limit)return true;
        return false;
    }
}