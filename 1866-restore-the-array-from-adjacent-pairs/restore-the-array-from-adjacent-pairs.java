class Solution {
    public int[] restoreArray(int[][] arr) {
        int n=arr.length;
        int[] ans=new int[n+1];
        HashMap<Integer,int[]> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i][0])){
                int[] a=map.get(arr[i][0]);
                a[1]=arr[i][1];
                map.put(arr[i][0],a);
            }else{
                int[] a=new int[2];
                a[0]=arr[i][1];
                a[1]=Integer.MAX_VALUE;
                map.put(arr[i][0],a);
            }
            if(map.containsKey(arr[i][1])){
                int[] a=map.get(arr[i][1]);
                a[1]=arr[i][0];
                map.put(arr[i][1],a);
            }else{
                int[] a=new int[2];
                a[0]=arr[i][0];
                a[1]=Integer.MAX_VALUE;
                map.put(arr[i][1],a);
            }
        }
        int start=0;
        for(int k:map.keySet()){
            // System.out.println(k+" "+Arrays.toString(map.get(k)));
            if(map.get(k)[1]==Integer.MAX_VALUE){
                start=k;
                break;
            }
        }
        HashSet<Integer> set=new HashSet<>();
        set.add(start);
        int i=1;
        ans[0]=start;
        start=map.get(start)[0];
        while(start!=Integer.MAX_VALUE){
            ans[i++]=start;
            set.add(start);
            int ns=map.get(start)[0];
            if(set.contains(ns)){
                ns=map.get(start)[1];
            }
            start=ns;
        }
        return ans;
    }
}