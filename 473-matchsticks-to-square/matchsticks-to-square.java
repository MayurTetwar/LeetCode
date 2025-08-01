class Solution {
    List<List<Integer>> list;
    HashMap<Long,Boolean> map;
    public boolean makesquare(int[] arr) {
        int total=0;
        for(int num:arr)total+=num;
        map=new HashMap<>();
        if(total%4!=0)return false;
        list=new ArrayList<>();
        helper(arr,0,new ArrayList<>(),total/4);
        // System.out.println(list);
        boolean ans=find(list,0,0,0);
        return ans;
    }
  
    public boolean find(List<List<Integer>> list,int i,int mask,int count){
        long str=((long)mask<<7)|(count<<4)|i;
        if(map.containsKey(str))return map.get(str);
        if(count==4){
            return true;
        }
        if(i==list.size() || count>4)return false;
     
        boolean valid=true;
        for(int ind:list.get(i)){
            if((mask&(1<<ind))!=0){
                valid=false;
                break;
            }
        }
        if(valid){
            for(int ind:list.get(i)){
                mask=(mask|(1<<ind));
            }
            //System.out.println(mask+" "+i);
            boolean val2=find(list,i+1,mask,count+1);
            if(val2){
                map.put(str,true);
                return true;
            }
            for(int ind:list.get(i)){
                mask=(mask&(~(1<<ind)));
            }
        }
        // }else System.out.println(list.get(i)+" inva");
        boolean val1=find(list,i+1,mask,count);
        map.put(str,val1);
        return val1;
    }

      public void helper(int[] arr,int i,List<Integer> set,int tar){
        if(tar==0){
            list.add(new ArrayList<>(set));
            return;
        }
        if(i==arr.length)return;
        helper(arr,i+1,set,tar);
        if(arr[i]<=tar){
            set.add(i);
            helper(arr,i+1,set,tar-arr[i]);
            set.remove(set.size()-1);
        }
    }
}
