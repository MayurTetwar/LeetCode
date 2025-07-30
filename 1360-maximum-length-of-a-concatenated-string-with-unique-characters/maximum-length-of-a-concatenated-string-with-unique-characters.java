class Solution {
    public int maxLength(List<String> list) {
        int n=list.size();
        int[] mask=new int[n];
        int i=0;
        for(String s:list){
            int val=0;
            boolean valid=true;
            for(char ch:s.toCharArray()){
                if((val&(1<<(ch-'a')))!=0){
                    valid=false;
                    break;
                }
                val=val|(1<<(ch-'a'));
            }
            if(valid)mask[i++]=val;
            else mask[i++]=-1;
        }
        return helper(mask,list,0,0);
    }
    public int helper(int[] mask,List<String> list,int i,int n){
        if(i==mask.length)return 0;
        int nottake=helper(mask,list,i+1,n);
        if(mask[i]==-1)return nottake;
        boolean valid=true;
        int nextn=n;
        for(int bit=0;bit<32;bit++){
            if((n&(1<<bit))==(mask[i]&(1<<bit))){
                if((n&(1<<bit))==0)continue;
                valid=false;
                break;
            }else{
                if((mask[i]&(1<<bit))!=0){
                    nextn=nextn|(1<<bit);
                }
            }
        }
        int take=0;
        if(valid){
            take=helper(mask,list,i+1,nextn)+list.get(i).length();
        }
        return Math.max(take,nottake);
    }
}