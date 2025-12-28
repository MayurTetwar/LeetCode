class Solution {
    public String minWindow(String s, String t) {
        int sl=s.length();
        int tl=t.length();
        int[] arr=new int[58];
        int[] arr2=new int[58];
        if(sl<tl)return "";
        int k=0;
        for(char ch:t.toCharArray()){
            if(arr2[ch-'A']==0)k++;
            arr2[ch-'A']++;
        }
        int left=0,right=0,st=0,min=Integer.MAX_VALUE;
        int count=0;
        while(right<sl){
            char ch=s.charAt(right);
            arr[ch-'A']++;
            if(arr2[ch-'A']>0 && arr[ch-'A']==arr2[ch-'A']){
                count++;
            }
            while(left<=right && count==k){
                ch=s.charAt(left);
                if(right-left+1<min){
                    min=right-left+1;
                    st=left;
                }
                arr[ch-'A']--;
                if(arr2[ch-'A']>0 && arr2[ch-'A']>arr[ch-'A']){
                    count--;
                }
                left++;
            }
            right++;
        }
        return (min==Integer.MAX_VALUE)?"":s.substring(st,st+min);
    }
}