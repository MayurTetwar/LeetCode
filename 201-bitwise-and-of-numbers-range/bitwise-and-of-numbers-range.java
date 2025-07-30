class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int n=0;
        int msbIndl= 31-Integer.numberOfLeadingZeros(left);
        int msbIndr= 31-Integer.numberOfLeadingZeros(right);
     //   System.out.println(msbIndl+" "+msbIndr);
        if(msbIndl!=msbIndr)return 0;
        boolean valid=true;
        while(msbIndl>=0 && valid){
            if((left&(1<<msbIndl))!=(right&(1<<msbIndl))){
                valid=false;
            }else{
                if((left&(1<<msbIndl))!=0)
                    n=n|(1<<msbIndl);
            }
            msbIndl--;
        }
        return n;
    }
}