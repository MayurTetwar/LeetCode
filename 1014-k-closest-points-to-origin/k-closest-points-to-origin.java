class Solution {
    public int[][] kClosest(int[][] arr, int k) {
        int n=arr.length;
        double[] count=new double[n];
        int i=0;
        for(int[] a:arr){
            count[i++]=Math.sqrt(a[0]*a[0]+a[1]*a[1]);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<>() {
            @Override
            public int compare(Integer a,Integer b){
                if(count[a]<count[b]){
                    return -1;
                }
                return 1;
            }
        });
        for(i=0;i<n;i++){
            pq.add(i);
        }
        int[][] ans=new int[k][2];
        for(i=0;i<k;i++){
            int j=pq.poll();
            ans[i][0]=arr[j][0];
            ans[i][1]=arr[j][1];
        }
        return ans;
    }
}