class Solution {
    public boolean judgePoint24(int[] arr) {
        List<Double> list=new ArrayList<>();
        for(int num:arr)list.add((double)num);
        return helper(list);
    }
    public boolean helper(List<Double> list){
        if(list.size()==1){
            if(Math.abs(list.get(0) - 24) < 1e-9)return true;
            return false;
        }
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(i==j)continue;
                List<Double> opr=combination(list.get(i),list.get(j));  
                double val1=list.get(i);
                double val2=list.get(j);
                if(i<j){
                    list.remove(j);
                    list.remove(i);
                }else{
                    list.remove(i);
                    list.remove(j);
                }
                for(double val:opr){
                    list.add(val);
                    if(helper(list))return true;
                    list.remove(list.size()-1);
                }
                if(i<j){
                    list.add(i,val1);
                    list.add(j,val2);
                }else{
                    list.add(j,val2);
                    list.add(i,val1);
                }
            }
        }
        return false;
    }
    public List<Double> combination(double a,double b){
        List<Double> opr = new ArrayList<>();
        opr.add(a+b);
        opr.add(a-b);
        opr.add(b-a);
        opr.add(a*b);
        if(b!=0)opr.add(a*1.0/b);
        if(a!=0)opr.add(b*1.0/a);
        return opr;
    }
}