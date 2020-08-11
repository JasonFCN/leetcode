### 位运算：
1，求绝对值：(n ^ ( n >> 31)) - (n >> 31)
2，求正整数位数：
    public static int bitcount(int n){
        if(n <= 0){
            return 0;
        }
        int count = 1;
        if((n >> 16) != 0){count += 16; n >>= 16;}
        if((n >> 8) != 0){count += 8; n >>= 8;}
        if((n >> 4) != 0){count += 4; n >>= 4;}
        if((n >> 2) != 0){count += 2; n >>= 2;}
        if((n >> 1) != 0){count += 1; n >>= 1;}
        return count;
    }
3，求整数二进制1bit位的个数：
    1） public static int bitCount(int i) {
            // HD, Figure 5-2
            i = i - ((i >>> 1) & 0x55555555);
            i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
            i = (i + (i >>> 4)) & 0x0f0f0f0f;
            i = i + (i >>> 8);
            i = i + (i >>> 16);
            return i & 0x3f;
        }
    2） public static int bitcount(int n){
            int count = 0;
            while(n!=0){
                n = n&(n-1);
                count++;
            }
            return count;
        }
    3)  public static int bitcount(int n){
            int count = 0;
            while(n!=0){
                if((n & 1)==1){
                    count++;
                }
                n >>>= 1;
            }
            return count;
        }
4，两数之和：
    public static int add(int a, int b) {
        while (b != 0) {
            int c = a ^ b;
            b = (a & b) << 1;
            a = c;
        }
        return a;
    }