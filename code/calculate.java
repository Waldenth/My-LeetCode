import java.util.*;
public class caculate {
    public static int computeValue(String exp){
        System.out.println(exp);
        int res=0;
        Stack<Integer>stack=new Stack<Integer>();
        int operand=0;  //求数字
        int op1,op2;    //计算式变量
        char cur=0;
        int nextIndex=0;
        while(nextIndex<exp.length()){
            cur=exp.charAt(nextIndex);
            nextIndex++;
            switch(cur){
                case '+':
                    op1=stack.pop();
                    op2=stack.pop();
                    stack.push(op2+op1);
                    continue;
                case '-':
                    op1=stack.pop();
                    op2=stack.pop();
                    stack.push(op2-op1);
                    continue;
                case '*':
                    op1=stack.pop();
                    op2=stack.pop();
                    stack.push(op2*op1);
                    continue;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    operand=operand*10+(int)(cur-'0');
                    continue;
                case ';':
                    stack.push(operand);
                    operand=0;//重置,准备计算下一个数字
                    continue;
                default:
                    continue;
            }
        }
        res=stack.peek();
        return res;
    }
    public static void main(String[] args) {
        System.out.println("The args number is "+args.length);
        if(args.length==0)
            System.out.println("Error,No expression!");
        String s=args[0];
        if(s.length()==0){
            System.out.println("expression is null.");
            return;
        }
        String postExp="";
        Stack<Character>stack=new Stack<Character>();
        int operand=0;  //计算运算式的每个数字
        char cur=0;
        int nextIndex=0;
        boolean hasAnumber=false;
        while(nextIndex<s.length()){
            cur=s.charAt(nextIndex);
            nextIndex++;
            switch(cur){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    operand=operand*10+(int)(cur-'0');
                    hasAnumber=true;
                    continue;
                case '+':
                case '-':
                    if(hasAnumber){//注意,这里是在处理上一个状态(数字)的工作,因为现在可以确定operand是一个数字了,直接将其存到postExp中,再处理本状态的工作         
                        postExp=postExp.concat(Integer.toString(operand)+";");
                        operand=0;
                        hasAnumber=false;
                    }
                    while(!stack.isEmpty()&&stack.peek()!='('){
                        String tmp=String.valueOf(stack.pop());
                        postExp=postExp.concat(tmp);
                    }
                    stack.push(cur);
                    continue;
                case '*':
                    if(hasAnumber){
                        postExp=postExp.concat(Integer.toString(operand)+";");
                        operand=0;
                        hasAnumber=false;
                    }
                    while(!stack.isEmpty()&&stack.peek()!='('&&stack.peek()!='+'&&stack.peek()!='-'){
                        String tmp=String.valueOf(stack.pop());
                        postExp=postExp.concat(tmp);
                    }
                    stack.push(cur);
                    continue;
                case '(':
                    stack.push(cur);
                    continue;
                case ')':
                    if(hasAnumber){
                        postExp=postExp.concat(Integer.toString(operand)+";");
                        operand=0;
                        hasAnumber=false;
                    }
                    while(stack.peek()!='('){
                        String tmp=String.valueOf(stack.pop());
                        postExp=postExp.concat(tmp);
                    }
                    stack.pop();
                    continue;
                default:
                    continue;
            }
        }
        if(hasAnumber)
            postExp=postExp.concat(Integer.toString(operand)+";");
        if(!stack.isEmpty()){
            while(!stack.isEmpty()){
                String tmp=String.valueOf(stack.pop());
                postExp=postExp.concat(tmp);
            }
        }
        System.out.println("the result is "+computeValue(postExp));
        return ;
    }
}
