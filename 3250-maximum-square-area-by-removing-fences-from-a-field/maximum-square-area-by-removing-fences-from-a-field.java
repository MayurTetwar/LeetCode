class Solution {
    public int maximizeSquareArea(int m, int n, int[] arr1, int[] arr2) {
        int len1=arr1.length;
        int len2=arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        List<Integer> list1=new ArrayList<>();
        int last=1;
        for(int num:arr1){
            list1.add(num-last);
            last=num;
        }
        list1.add(m-last);

        List<Integer> list2=new ArrayList<>();
        last=1;
        for(int num:arr2){
            list2.add(num-last);
            last=num;
        }
        list2.add(n-last);

        m=list1.size();
        n=list2.size();
        HashSet<Long> set=new HashSet<>();
        for(int i=0;i<m;i++){
            long sum=0;
            for(int j=i;j<m;j++){
                sum+=list1.get(j);
                set.add(sum);
            }
        }
        // System.out.println(set);
        // System.out.println(list2);
        long max=-1;
        for(int i=0;i<n;i++){
            long sum=0;
            for(int j=i;j<n;j++){
                sum+=list2.get(j);
                if(set.contains(sum)){
                    max=Math.max(max,sum);
                }
            }
        }
        if(max==-1)return -1;
        return (int)((max*max)%1000000007);
    }
}