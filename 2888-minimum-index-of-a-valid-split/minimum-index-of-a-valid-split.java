class Solution {
    static{
        for(int i=0;i<500;i++){
            minimumIndex(new ArrayList<>());
        }
    }
    public static int minimumIndex(List<Integer> list) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int n=list.size();
        for(int i=0;i<n;i++){
            int val=list.get(i);
            if(map.containsKey(val)){
                List<Integer> l=map.get(val);
                l.add(i);
                map.put(val,l);
            }else{
                List<Integer> l=new ArrayList<>();
                l.add(i);
                map.put(val,l);
            }
        }
        int max=0;
        List<Integer> maxList=new ArrayList<>();
        for(int num:map.keySet()){
            if(map.get(num).size()*2>n){
                max=num;
                maxList=map.get(num);
                break;
            }
        }
        int frq=1;
        int m=maxList.size();
        for(int i=0;i<m-1;i++){
            if(frq*2>maxList.get(i)+1){
                if((m-frq)*2>n-maxList.get(i)-1){
                    return maxList.get(i);
                }
            }else if(frq*2>maxList.get(i+1)){
                if((m*frq)*2>n-maxList.get(i+1)){
                    return maxList.get(i+1);
                }
            }
            frq++;
        }
        return -1;
    }
}