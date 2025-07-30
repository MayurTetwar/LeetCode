class Solution {
    public int maxProduct(String[] arr) {
        int n=arr.length;
        int[] mask=new int[n];
        int i=0;
        for(String s:arr){
            int val=0;
            for(char ch:s.toCharArray()){
                val=val|(1<<(ch-'a'));
            }
            mask[i++]=val;
        }
        int max=0;
        for(i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                boolean valid=true;
                for(int bit=0;bit<32;bit++){
                    if((mask[i]&(1<<bit))==(mask[j]&(1<<bit))){
                        if((mask[i]&(1<<bit))==0)continue;
                        valid=false;
                        break;
                    }
                }
                if(valid && max<(arr[i].length()*arr[j].length())){
                    max=arr[i].length()*arr[j].length(); 
                }
            }
        }
        return max;
    }
}