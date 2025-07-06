class FindSumPairs {
    HashMap<Integer,Integer> map;
    int[] arr1;
    int[] arr2;
    public FindSumPairs(int[] arr1, int[] arr2) {
        map=new HashMap<>();
        this.arr1=arr1;
        this.arr2=arr2;
        for(int i=0;i<arr2.length;i++){
            map.put(arr2[i],map.getOrDefault(arr2[i],0)+1);
        }
    }
    
    public void add(int index, int val) {
        int num=arr2[index];
        arr2[index]+=val;
        map.put(num,map.get(num)-1);
        map.put(num+val,map.getOrDefault(num+val,0)+1);
    }
    
    public int count(int tot) {
        int ans=0;
        for(int i=0;i<arr1.length;i++){
            if(map.containsKey(tot-arr1[i])){
                ans+=map.get(tot-arr1[i]);
            }
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */