class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            int bit1=Integer.bitCount(a);
            int bit2=Integer.bitCount(b);
            if(bit1!=bit2)return bit1-bit2;
            return a-b;
        });
        for(int num:arr)pq.add(num);
        for(int i=0;i<arr.length;i++){
            arr[i]=pq.poll();
        }
        return arr;
    }
}