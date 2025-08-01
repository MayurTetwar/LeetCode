class Solution {
    List<List<Integer>> list;
    public boolean makesquare(int[] arr) {
        int total=0;
        for(int num:arr)total+=num;
        if(total%4!=0)return false;
        list=new ArrayList<>();
        helper(arr,0,new ArrayList<>(),total/4);
        // System.out.println(list);
        boolean[] visi=new boolean[16];
        boolean ans=find(list,0,visi,0);
        return ans;
    }
  
    public boolean find(List<List<Integer>> list,int i,boolean[] visi,int count){
        if(count==4){
            return true;
        }
        if(i==list.size() || count>4)return false;
     
        boolean valid=true;
        for(int ind:list.get(i)){
            if(visi[ind]){
                valid=false;
                break;
            }
        }
        if(valid){
            for(int ind:list.get(i)){
                visi[ind]=true;
            }
            // System.out.println(list.get(i)+" "+(count+1));
            boolean val2=find(list,i+1,visi,count+1);
            if(val2)return true;
            for(int ind:list.get(i)){
                visi[ind]=false;
            }
        }
        // }else System.out.println(list.get(i)+" inva");
        boolean val1=find(list,i+1,visi,count);
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
