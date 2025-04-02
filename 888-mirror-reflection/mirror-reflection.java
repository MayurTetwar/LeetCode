class Solution {
    public int mirrorReflection(int p, int q) {
        if(p==q)return 1;
        int lastDis=q;
      //  int i=0;
        boolean right=false;
        boolean top=true;
        while(!((lastDis==p && !right)||(lastDis==p && right)||(lastDis==0 && right))){
            if(top){
                if(lastDis+q<=p){
                    lastDis+=q;
                }else{
                    lastDis=(p-(lastDis+q-p));
                    top=!top;
                }
                right=!right;
            }else{
                if(lastDis-q>=0){
                    lastDis-=q;
                }else{
                    lastDis=q-lastDis;
                    top=!top;
                }
                right=!right;
            }
          //  if(i++>10)break;
           // System.out.println(lastDis+" ");
        }
        if(lastDis==p && right)return 2;
        if(lastDis==p && !right)return 1;
        return 0;
    }
}