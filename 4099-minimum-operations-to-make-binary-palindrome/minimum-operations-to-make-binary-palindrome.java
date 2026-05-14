class Solution {
    static List<Integer> poli=new ArrayList<>();
    static int[] min=new int[50001];
    static{
        helper();
    }
    public static int[] minOperations(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(arr[i]-min[arr[i]]);
        }
        return ans;
    }
    public static void helper(){
        for(int i=0;i<=5000;i++){
            String bi=Integer.toString(i,2);
            int left=0,right=bi.length()-1;
            boolean flag=true;
            while(left<right){
                if(bi.charAt(left)!=bi.charAt(right)){
                    flag=false;
                    break;
                }
                left++;
                right--;
            }
            if(flag){
                poli.add(i);
            }
        }
        for(int i=0;i<poli.size()-1;i++){
            int left=poli.get(i);
            int right=poli.get(i+1);
            int lv=left;
            int rv=right;
            while(left<right){
                min[left]=lv;
                min[right]=rv;
                left++;
                right--;
            }
            if(left==right)min[left]=lv;
        }
        // System.out.println(poli);
        int right=poli.get(poli.size()-1);
        int rv=right;
        while(right<=5000){
            min[right]=rv;
            right++;
        }
    }
}