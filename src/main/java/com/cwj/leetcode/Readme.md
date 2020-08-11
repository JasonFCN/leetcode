位运算：
1，两个变量交换：

int a = 3, b = 4;
a = a ^ b;
b = a ^ b;
a = a ^ b;

2，使出现三次的数变为0：
int x = 3;

int seen_once = 0, seen_twice = 0;

seen_once = ~seen_twice & (seen_once ^ x);
seen_twice = ~seen_once & (seen_twice ^ x);

seen_once = ~seen_twice & (seen_once ^ x);
seen_twice = ~seen_once & (seen_twice ^ x);

seen_once = ~seen_twice & (seen_once ^ x);
seen_twice = ~seen_once & (seen_twice ^ x);

seen_once 为 0;

3, 字母大小写转换：
char a = 'A';
a ^= (1 << 5);
