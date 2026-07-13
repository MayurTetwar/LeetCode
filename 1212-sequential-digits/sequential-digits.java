class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        for(int i=2;i<10;i++){
            int num=0;
            int ele=0;
            for(int j=0;j<i;j++){
                num=num*10+(j+1);
                ele=ele*10+1;
            }
            // System.out.println(num+" "+ele);
            for(int k=i;k<10;k++){
                if(low<=num && num<=high)ans.add(num);
                num+=ele;
            }
        }
        return ans;
    }
}