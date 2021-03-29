public class Solution { //循环
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        for(int i=0;i<32;i++){
            int tmp=n&1;
            res=(res<<1)|tmp;
            n=n>>>1;
        }
        return res;
    }
}


public class aSolution{ //分治
    private static int M1=0x55555555;
    private static int M2=0x33333333;
    private static int M4=0x0f0f0f0f;
    private static int M8=0x00ff00ff;

    public int reverseBits(int n){
        n= (n>>>1&M1) | ((n&M1) <<1);  //相邻2位 互换
        n= (n>>>2&M2) | ((n&M2)<<2);   //2位和2位互换
        n= (n>>>4&M4) | ((n&M4)<<4);
        n= (n>>>8&M8) | ((N&M8)<<8);

        return n>>>16 | n<<16;
    }
}

