class Robot {
    String[] dir;
    int d,x,y,n,m;
    public Robot(int width, int height) {
        dir=new String[]{"East","North","West","South"};
        d=0;
        n=width;
        m=height;
        x=0;
        y=0;
    }
    
    public void step(int num) {
        while(num>n*2+m*2-4){
            num-=n*2+m*2-4;
        }
        while(num>0){
            if(d==0){
                if(x+num>n-1){
                    num-=n-x-1;
                    x=n-1;
                    d++;
                }else{
                    x+=num;
                    num=0;
                }
            }else if(d==1){
                if(y+num>m-1){
                    num-=m-y-1;
                    y=m-1;
                    d++;
                }else{
                    y+=num;
                    num=0;
                }
            }else if(d==2){
                if(x-num<0){
                    num-=x;
                    x=0;
                    d++;
                }else{
                    x-=num;
                    num=0;
                }
            }else{
                if(y-num<0){
                    num-=y;
                    y=0;
                    d++;
                }else{
                    y-=num;
                    num=0;
                }
            }
            d=d%4;
        }
        // System.out.println(x+" "+y+" "+d+" "+num);
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        return dir[d];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */