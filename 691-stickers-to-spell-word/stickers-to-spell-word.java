class Solution {
    HashMap<String,Integer> map;
    public int minStickers(String[] strArr, String tar) {
        int[] tarc=new int[26];
        int n=strArr.length;
        int m=tar.length();
        map=new HashMap<>();
        for(int i=0;i<m;i++){
            tarc[tar.charAt(i)-'a']++;
        }
        int[][] count=new int[n][26];
        for(int i=0;i<n;i++){
            for(int j=0;j<strArr[i].length();j++){
                count[i][strArr[i].charAt(j)-'a']++;
            }
        }
        int ans=helper(count,tarc,0);
        if(ans==101)return -1;
        return ans;
    }
    public int helper(int[][] count,int[] tarc,int i){
        String str=Arrays.toString(tarc)+"_"+i;
        if(map.containsKey(str)){
            return map.get(str);
        }
        if(i>=count.length){
            boolean valid=true;
            for(int k=0;k<26;k++){
                if(tarc[k]>0){
                    valid=false;
                    break;
                }
            }
            if(!valid)return 101;
            return 0;
        }
        int val1=helper(count,tarc,i+1);
        boolean valid=false;
        int[] newt=new int[26];
        int val2=101;
        for(int k=0;k<26;k++){
            if(tarc[k]>0 && count[i][k]>0){
                if(tarc[k]>=count[i][k]){
                    newt[k]=tarc[k]-count[i][k];
                }else{
                    newt[k]=0;
                }
                valid=true;
            }else{
                newt[k]=tarc[k];
            }
        }
        if(valid){
            val2=helper(count,newt,i)+1;
        }
        map.put(str,Math.min(val1,val2));
        return Math.min(val1,val2);
    }
}