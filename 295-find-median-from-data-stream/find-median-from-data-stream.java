class MedianFinder {
    List<Integer> list;
    public MedianFinder() {
        list=new ArrayList<>();
    }
    
    public void addNum(int num) {
        int st=0,end=list.size();
        while(st<end){
            int mid=st+(end-st)/2;
            if(list.get(mid)>=num){
                end=mid;
            }else{
                st=mid+1;
            }
        }
        list.add(st,num);
    }
    
    public double findMedian() {
        if(list.size()%2!=0){
            return list.get(list.size()/2)*1.0;
        }
        return (list.get(list.size()/2)+list.get((list.size()/2)-1))/2.0;
   
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */