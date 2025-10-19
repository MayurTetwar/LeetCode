class Solution {
    public String lexGreaterPermutation(String s, String tar) {
        int n=s.length();
        int[] cnt=new int[26];
        for(char ch:s.toCharArray())cnt[ch-'a']++;
        char[] ans=new char[n];
        int mark=-1;
        int ind=-1;
        for(int i=0;i<n;i++){
            if(cnt[tar.charAt(i)-'a']>0){
                ans[i]=tar.charAt(i);
                cnt[tar.charAt(i)-'a']--;
            }else{
                mark=i;
                break;
            }
        }
        boolean req=true;
        if(mark!=-1){
            for(int i=0;i<26;i++){
                if((char)(i+'a')>tar.charAt(mark) && cnt[i]>0){
                    ind=i;
                    break;
                }
            }
            if(ind!=-1){
                cnt[ind]--;
                ans[mark]=(char)(ind+'a');
                ind=mark+1;
                req=false;
            }else{
                req=true;
            }
        }else mark=n;
        if(req){
                boolean flag=false;
                int ki=-1;
                for(int i=mark-1;i>=0;i--){
                    for(int j=0;j<26;j++){
                        if((char)(j+'a')>ans[i] && cnt[j]>0){
                            ind=j;
                            ki=i;
                            flag=true;
                            break;
                        }
                    }
                    if(flag)break;
                    cnt[ans[i]-'a']++;
                }
                if(!flag)return "";
                cnt[ans[ki]-'a']++;
                ans[ki]=(char)(ind+'a');
                cnt[ind]--;
                ind=ki+1;
        }
        for(int i=0;i<26;i++){
            while(cnt[i]>0){
                ans[ind++]=(char)(i+'a');
                cnt[i]--;
            }
        }
        return new String(ans);
    }
}
/*
"dcbadcbadcbadcbadcbadcbadcbadcbadcbadcbadcbadcbadc"
"dcbadcbadcbadcbadcbadcbadcbadcbadcbadcbadcbadcbbaa"
*/