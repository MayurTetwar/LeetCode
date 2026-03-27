class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(a>0 && b>0){
                return a-b;
            }else if(a<0 && b<0){
                return b-a;
            }else{
                return a-b;
            }
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
            if(num==0){
                if(c1%2==0){
                    count+=c1/2;
                }
                continue;
            }
            if(c1==0)continue;
            if(!map.containsKey(num*2)){
                return false;
            }
            int c2=map.get(num*2);
            // System.out.println(num+" "+set+","+c1+" "+c2);
            if(c1>c2)return false;
            int rem=c2-c1;
            count+=c1;
            map.put(num*2,rem);
        }
        return count==n/2;
    }
}