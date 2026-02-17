class Solution {
    public List<String> readBinaryWatch(int on) {
        List<int[]> list=new ArrayList<>();
        int[] ho=new int[]{1,2,4,8};
        int[] min=new int[]{1,2,4,8,16,32};
        helper(list,ho,min,0,0,0,0,on);
        HashSet<String> ans=new HashSet<>();
        for(int[] a:list){
            StringBuilder sb=new StringBuilder();
            sb.append(a[0]);
            sb.append(":");
            if(a[1]<10){
                sb.append("0");
            }
            sb.append(a[1]);
            ans.add(sb.toString());
        }
        List<String> res= new ArrayList<>();
        for(String s:ans){
            res.add(s);
        }
        // Collections.sort(res);
        return res;
    }
    public void helper(List<int[]> list,int[] ho,int[] min,int i,int j,int val1,int val2,int on){
        // System.out.println(i+" "+j);
        if(on==0){
            list.add(new int[]{val1,val2});
            return;
        }
        if(i<4){
            helper(list,ho,min,i+1,j,val1,val2,on);
            if(val1+ho[i]<12){
                helper(list,ho,min,i+1,j,val1+ho[i],val2,on-1);
            }
        }
        if(j<6){
            helper(list,ho,min,i,j+1,val1,val2,on);
            if(val2+min[j]<60){
                helper(list,ho,min,i,j+1,val1,val2+min[j],on-1);
            }
        }
    }
}