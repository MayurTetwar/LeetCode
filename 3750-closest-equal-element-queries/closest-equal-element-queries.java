class Solution {
    public List<Integer> solveQueries(int[] arr, int[] que) {
        int n=arr.length;
        int m=que.length;
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            List<Integer> list=map.getOrDefault(arr[i],new ArrayList<>());
            list.add(i);
            map.put(arr[i],list);
        }
        for(int idx:que){
            if(map.get(arr[idx]).size()==1){
                ans.add(-1);
            }else{
                List<Integer> list=map.get(arr[idx]);
                int start=0;
                int end=list.size()-1;
                int mid=0;
                while(start<=end){
                    mid=start+(end-start)/2;
                    if(list.get(mid)==idx){
                        break;
                    }else if(list.get(mid)<idx){
                        start=mid+1;
                    }else{
                        end=mid-1;
                    }
                }
                int max=0;
                //int toAdd=0;
                //System.out.println(list+" "+mid+" "+idx);
                if(mid+1==list.size()){
                    max=Math.min(n-(idx-list.get(0)),(idx-list.get(mid-1)));
                }else if(mid==0){
                    max=Math.min(n-(list.get(list.size()-1)-idx),(list.get(mid+1)-idx));
                }else{
                   max= Math.min(list.get(mid+1)-idx,idx-list.get(mid-1));
                }
                ans.add(max);
            }
        }
        return ans;
    }
}