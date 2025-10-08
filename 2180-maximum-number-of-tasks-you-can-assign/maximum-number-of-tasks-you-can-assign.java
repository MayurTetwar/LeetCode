class Solution {
    public int maxTaskAssign(int[] task, int[] arr, int pill, int str) {
        Arrays.sort(task);
        Arrays.sort(arr);
        int n=task.length;
        int m=arr.length;
        int st=1,end=Math.min(n,m);
        while(st<=end){
            int mid=st+(end-st)/2;
            if(check(task,mid,arr,pill,str)){
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return st-1;
    }
    public boolean check(int[] task,int end,int[] arr,int p,int str){
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=arr.length-end;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=end-1;i>=0;i--){
            Integer key=map.lastKey();
            if(key>=task[i]){
                map.put(key,map.get(key)-1);
                if(map.get(key)==0){
                    map.remove(key);
                }
            }else{
                if(p==0)return false;
                key=map.ceilingKey(task[i]-str);
                if(key==null)return false;
                map.put(key,map.get(key)-1);
                if(map.get(key)==0){
                    map.remove(key);
                }
                p--;
            }
        }
        return true;
    }
}