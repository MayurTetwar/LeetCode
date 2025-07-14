class MedianFinder {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
       if(max.size()==0 || num<=max.peek())max.add(num);
       else min.add(num);
       if(max.size()>min.size()+1){
            min.add(max.poll());
       }else if(min.size()>max.size()){
            max.add(min.poll());
       }
    }
    
    public double findMedian() {
        if(min.size()==max.size()){
            return (min.peek()+max.peek())/2.0;
        }
        return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */