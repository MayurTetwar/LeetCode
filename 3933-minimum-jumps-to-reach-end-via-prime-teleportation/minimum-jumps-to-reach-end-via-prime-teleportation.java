class Solution {
    static int MAX=1000001;
    static List<Integer>[] list = new ArrayList[MAX];
    static{
        for (int i = 0; i < MAX; i++) list[i] = new ArrayList<>();
        for (int i = 2; i < MAX; i++) {
            if (list[i].isEmpty()) {
                for (int j = i; j < MAX; j += i) list[j].add(i);
            }
        }
    }
    static public int minJumps(int[] arr) {
        int n=arr.length;
        boolean[] visi=new boolean[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(list[arr[i]].size()==1){
                map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }
        }
        int res=0;
        visi[n-1]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(n-1);
        while(true){
            int size=q.size();
            while(size-->0){
                int i=q.poll();
                if(i==0)return res;
                if(i>0 && !visi[i-1]){
                    visi[i-1]=true;
                    q.add(i-1);
                }
                if(i<n-1 && !visi[i+1]){
                    visi[i+1]=true;
                    q.add(i+1);
                }
                for(int p:list[arr[i]]){
                    if(map.containsKey(p)){
                        for(int j:map.get(p)){
                            if(!visi[j]){
                                visi[j]=true;
                                q.add(j);
                            }
                        }
                        map.get(p).clear();
                    }
                }
            }
            res++;
        }
    }
}