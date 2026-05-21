class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
       HashSet<Integer> arr1Pre=new HashSet<>();
       for(int i=0;i<arr1.length;i++){
          while(!arr1Pre.contains(arr1[i]) && arr1[i]>0){
              arr1Pre.add(arr1[i]);
             arr1[i]/=10;
          }
       }
       int max=0;
       for(int i=0;i<arr2.length;i++){
            while(arr2[i]>0){
                if(arr1Pre.contains(arr2[i])){
                    String str=String.valueOf(arr2[i]);
                    if(max<str.length()){
                        max=str.length();
                    }
                    break;
                }
                arr2[i]/=10;
            }
       }
       return max; 
    }
}