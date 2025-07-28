class Solution {
    HashMap<String,Integer> map;
    public int minStickers(String[] strArr, String tar) {
        map=new HashMap<>();
        int n=strArr.length;
        int[][] count=new int[n][26];
        for(int i=0;i<n;i++){
            for(int j=0;j<strArr[i].length();j++){
                count[i][strArr[i].charAt(j)-'a']++;
            }
        }
        int ans=helper(count,tar);
        if(ans==101)return -1;
        return ans;
    }
    public int helper(int[][] count,String tar){
        if(map.containsKey(tar)){
            return map.get(tar);
        }
        if(tar.length()==0)return 0;
        int[] tarc=new int[26];
      //  System.out.println(tar);
        for(int i=0;i<tar.length();i++){
            tarc[tar.charAt(i)-'a']++;
        }
        int ans=101;
        for(int i=0;i<count.length;i++){
            boolean valid=false;
            int[] newt=new int[26];
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
                StringBuilder sb=new StringBuilder();
                for(int k=0;k<26;k++){
                    while(newt[k]>0){
                        sb.append((char)(k+'a'));
                        newt[k]--;
                    }
                }
                ans=Math.min(ans,helper(count,sb.toString())+1);
            }
        }
        map.put(tar,ans);
        return ans;
    }
}