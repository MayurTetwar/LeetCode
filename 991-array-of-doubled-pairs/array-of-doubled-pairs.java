class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            return Math.abs(a)-Math.abs(b);
        });
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            pq.add(arr[i]);
        }
        int count=0;
        HashSet<Integer> set=new HashSet<>();
        while(!pq.isEmpty()){
            int num=pq.poll();
            if(set.contains(num))continue;
            set.add(num);
            int c1=map.get(num);
            if(c1==0)continue;
            if(!map.containsKey(num*2)){
                return false;
            }
            int c2=map.get(num*2);
            if(c1>c2)return false;
            map.put(num*2,c2-c1);
        }
        return true;
    }
}