class Solution {
    public List<Integer> findMissingElements(int[] arr) {
        Arrays.sort(arr);
        List<Integer> list=new ArrayList<>();
        HashSet<Integer> set=new HashSet<>();
        for(int num:arr)set.add(num);
        for(int i=arr[0];i<arr[arr.length-1];i++){
            if(!set.contains(i))list.add(i);
        }
        return list;
    }
}