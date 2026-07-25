class Solution {
    public int maxProduct(int n) {
        int save=n;
        int max=0;
        int ind=-1;
        int i=0;
        while(save>0){
            int num=save%10;
            if(num>max){
                max=num;
                ind=i;
            }
            save=save/10;
            i++;
        }
        int max2=0;
        i=0;
        while(n>0){
            int num=n%10;
            // System.out.println(ind+" "+i);
            if(num>max2 && i!=ind){
                max2=num;
                    
            }
            n=n/10;
            
            
            i++;
        }
        return max*max2;
    }
}