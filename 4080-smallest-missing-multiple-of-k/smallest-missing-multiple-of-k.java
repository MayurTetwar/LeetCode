class Solution {
    public int missingMultiple(int[] arr, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:arr)set.add(num);
        int curr=k;
        while(set.contains(curr)){
            curr+=k;
        }        
        return curr;
    }
}