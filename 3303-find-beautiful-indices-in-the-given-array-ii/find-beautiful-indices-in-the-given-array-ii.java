class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> list1=search(s,a);
        List<Integer> list2=search(s,b);
        List<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        while(i<list1.size() && j<list2.size()){
            if(Math.abs(list1.get(i)-list2.get(j))<=k){
                ans.add(list1.get(i));
                i++;
            }else{
                if(list1.get(i)<list2.get(j)){
                    i++;
                }else{
                    j++;
                }
            }
        }
        return ans;
    }
    private int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0, i = 1;
        
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                lps[i++] = ++len;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i++] = 0;
                }
            }
        }
        return lps;
    }

    // KMP search
    public List<Integer> search(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        List<Integer> res = new ArrayList<>();
        int[] lps = buildLPS(pat);
        
        int i = 0, j = 0;
        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++; j++;
                if (j == m) {
                    res.add(i - j);  // found occurrence
                    j = lps[j - 1]; // continue search
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}