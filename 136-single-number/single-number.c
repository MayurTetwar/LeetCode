int singleNumber(int* nums, int numsSize) {
    int temp , n = numsSize;
    for(int i = 0 ; i<n-1; i++){
        int sorted =1;
        for(int j = 0 ; j< n-i-1; j++){
            if(nums[j]> nums[j+1]){
                temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
                sorted =0;
            }
        }
        if(sorted){
            break;
        }
    }
    for(int k = 0 ; k < n-2 ; k+=2){
        if(nums[k] != nums[k+1]){
            return nums[k];
            break;
        }
    }
    return nums[n-1];
}