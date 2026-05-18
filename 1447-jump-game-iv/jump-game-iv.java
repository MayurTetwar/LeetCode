class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int num=arr[i];
            if(!map.containsKey(num)){
                map.put(num,new ArrayList<>());
            }
            List<Integer> idx=map.get(num);
            idx.add(i);
            map.put(num,idx);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] visi=new boolean[n];
        int ans=0;
        q.add(0);
        visi[0]=true;
        while(!q.isEmpty()){
            int size=q.size();
            // System.out.println(q);
            while(size-->0){
                int curr=q.poll();
                if(curr==n-1)return ans;
                if(curr-1>=0 && !visi[curr-1]){
                    q.add(curr-1);
                    visi[curr-1]=true;
                }
                if(!visi[curr+1]){
                    q.add(curr+1);
                    visi[curr+1]=true;
                }
                if(map.containsKey(arr[curr])){
                    for(int idx:map.get(arr[curr])){
                        if(visi[idx])continue;
                        q.add(idx);
                        visi[idx]=true;
                    }
                    map.remove(arr[curr]);
                }
            }
            ans++;
        }
        return -1;
    }
}