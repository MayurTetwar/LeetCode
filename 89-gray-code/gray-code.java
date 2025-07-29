class Solution {
    public List<Integer> grayCode(int n) {
        int max=(1<<n)-1;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=max;i++){
            list.add(i^(i>>1));
        }
        return list;
    }
}