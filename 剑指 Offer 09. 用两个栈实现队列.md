#### [剑指 Offer 09. 用两个栈实现队列](https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/)



用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 `appendTail` 和 `deleteHead` ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，`deleteHead` 操作返回 -1 )

 

**示例 1：**

```
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
```

**示例 2：**

```
输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
```

**提示：**

- `1 <= values <= 10000`
- `最多会对 appendTail、deleteHead 进行 10000 次调用`



**思路**

栈是**FILO**，队列是**FIFO**，两者的弹出策略刚好是相反的，把元素存在一个栈中，最先压入的元素在最底下，由于要模拟队列，因此要把最先压入的元素弹出，由于只能用栈的进出策略，因此要把最底下的那个元素想办法放到最上面来，所以要把这个栈的元素全部按照**FILO**策略弹出并且压入到另外一个栈中。然后在这另外一个栈中弹出一个元素，此时就成了**FIFO**.

**FI_1 + LO_1 + FI_2 = 实现数据结构中元素逆序**

**LO_2 = 逆序元素后进先出，即正序元素先进先出**

如果此时第二个栈中存在元素，说明目前前面压入的元素还有部分存在，则暂时不需要将栈1的元素弹出压入到第二个栈中，直接从第二个栈中弹出元素即可。

**java**

```java
class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public CQueue() {
        stack1=new Stack<Integer>();
        stack2=new Stack<Integer>();
    }
    public void appendTail(int value) {
        stack1.add(value);
    }
    public int deleteHead() {
        if(stack2.empty()){
            int tmp=0;
            while(!stack1.empty()){
                tmp=stack1.pop();
                stack2.add(tmp);
            }
        }
        if(stack2.empty())
            return -1;
        return stack2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
```

