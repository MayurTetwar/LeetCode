class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str=version1.split("\\.");
        String[] str2=version2.split("\\.");
       // if(str.length!=str2.length)return 0;
        // System.out.println(version1.split("."));
        int j=0;
        for(int i=0;i<Math.min(str.length,str2.length);i++){
            if(Long.valueOf(str[i])<Long.valueOf(str2[i]))return -1;
            if(Long.valueOf(str[i])>Long.valueOf(str2[i]))return 1;
            j++;
        }
        if(j==str.length){
            while(j<str2.length && 0==Long.valueOf(str2[j]))j++;
            if(j<str2.length)return -1;
        }else{
            while(j<str.length && 0==Long.valueOf(str[j]))j++;
            if(j<str.length)return 1;
        }
        return 0;
    }

}