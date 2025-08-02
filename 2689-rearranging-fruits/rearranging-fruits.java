class Solution {
    public long minCost(int[] arr1, int[] arr2) {
        int n=arr1.length;
        HashSet<Integer> set=new HashSet<>();
        HashMap<Integer,Integer> map1=new HashMap<>();
        HashMap<Integer,Integer> map2=new HashMap<>();
        for(int num:arr1){
            map1.put(num,map1.getOrDefault(num,0)+1);
            set.add(num);
        }
        for(int num:arr2){
            map2.put(num,map2.getOrDefault(num,0)+1);
            set.add(num);
        }
        List<Integer> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        long ans=0;
        int min=Integer.MAX_VALUE;
        for(int k:set){ 
            min=Math.min(min,k);
            int c1=0,c2=0;
            if(map1.containsKey(k)){
                c1=map1.get(k);
            }
            if(map2.containsKey(k)){
                c2=map2.get(k);
            }
            if((c1+c2)%2==1)return -1;
            if(c1==c2)continue;
            if(c1<c2){
                int avg=(c1+c2)/2;
                while(c1<avg){
                    list2.add(k);
                    c1++;
                }
            }else{
                int avg=(c1+c2)/2;
                while(c2<avg){
                    list1.add(k);
                    c2++;
                }
            }
        }
        Collections.sort(list1);
        Collections.sort(list2,Collections.reverseOrder());
        for(int i=0;i<list1.size();i++){
            long minCost=min*2L;
            minCost=Math.min(minCost,Math.min(list1.get(i),list2.get(i)));
            ans+=minCost;
        }
        return ans;
    }
    /*
        4,5,5,
        1,2,3,
        int min=Math.min(arr1[0],arr2[0]);
        int i=0,j=0;
        long ans=0;
        while(i+1<n && j+1<n){
            while(i+1<n && arr1[i]!=arr1[i+1])i++;
            while(j+1<n && arr2[j]!=arr2[j+1])j++;
            if(arr1[i]!=arr2[j]){

                long minCost=Math.min(min*2,Math.min(arr1[i],arr2[j]));
                ans+=minCost;
                // System.out.println(i+" "+j);
                i+=2;
                j+=2;
            }
        }
    */
}