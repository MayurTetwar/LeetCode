class LockingTree {
    List<List<Integer>> list;
    int[] lock;
    int[] par;
    public LockingTree(int[] arr) {
        par=arr.clone();
        int n=arr.length;
        lock=new int[n];
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            if(arr[i]==-1)continue;
            list.get(arr[i]).add(i);
        }
    }
    
    public boolean lock(int num, int user) {
        if(lock[num]!=0)return false;
        lock[num]=user;
        return true;
    }
    
    public boolean unlock(int num, int user) {
        if(lock[num]!=user)return false;
        lock[num]=0;
        return true;
    }
    
    public boolean upgrade(int num, int user) {        
        int curr=num;
        while(num!=-1){
            if(lock[num]!=0)return false;
            num=par[num];
        }
        if(!isLock(curr))return false;
        lock[curr]=user;
        return true;
    }
    public boolean isLock(int num){
        Queue<Integer> q=new LinkedList<>();
        q.add(num);
        boolean flag=false;
        while(!q.isEmpty()){
            int node=q.poll();
            if(lock[node]!=0){
                flag=true;
                lock[node]=0;
            }
            for(int next:list.get(node)){
                q.add(next);
            }
        }
        return flag;
    }
}

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */