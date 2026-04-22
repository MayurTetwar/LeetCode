int divide(long a,long b){
    if(a==INT_MIN){
        if(b==1)return a;
        if(b==-1)return INT_MAX;
    }
    int negative=0;
    if(a<0^b<0)negative=1;
    a=llabs(a);
    b=llabs(b);
    if(b==1&&negative)return -a;
    if(b==1&&!negative)return a;
    int c=0;
    while(a>=b){
        a-=b;
        c++;
    }
    if(negative)return -c;
    return c;
}