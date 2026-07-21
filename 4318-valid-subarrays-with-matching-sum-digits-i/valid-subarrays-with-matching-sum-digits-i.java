class Solution {
    public int countValidSubarrays(int[] arr, int x) {
        int n=arr.length;
        long sum = 0;
        int ans=0;
        long last, first =0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n ; j++){
                sum+= arr[j]; 
                 
                long f = sum;
                while(f>=10){
                    f=f/10;
                }
                first = f;
                last = sum%10;
                
                if(first ==x &&last==x) ans++;
                
            }sum =0;
        }   
        return ans;
                
//ok shit apn ne random substring ni sirf seq vali liye hhh ohno
                  // haa to 
//arrayl    ///aur??is
                  // nhi nhi 
                  // long use kar integer overflow ho rha hait
                  // ??hainnn
                  // bs sum m ha brbr//aur ky gdbd h//btaanaaaaa
                  
                  // hogya kyaa ???????
    }
}