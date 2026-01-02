class Solution {
    public int repeatedNTimes(int[] arr) {
        int[] count=new int[10001];
        int n=arr.length;
        for(int num:arr){
            count[num]++;
            if(count[num]==(n/2))return num;
        }
        return -1;
    }
}