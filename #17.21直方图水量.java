class Solution {
    public int trap(int[] height) {
        if(height.length<=2)
            return 0;
        
        Deque<Integer>stack=new ArrayDeque<>();
        
        int ans=0;

        for(int i=0;i<height.length;i++){
            //System.out.println(stack.peekFirst()+" "+i);
            if(stack.size()==0){
                stack.addFirst(i);
            }else{
                if(height[stack.peekFirst()]>=height[i]){
                    stack.addFirst(i);
                }else{
                    while(stack.size()>0){
                        int bottom=height[stack.pop()];
                        //System.out.println("bottom="+bottom);
                        if(stack.size()>0){
                            if(height[stack.peekFirst()]==bottom){
                                stack.pop();
                            }
                            if(stack.size()>0){
                                //System.out.println("left="+height[stack.peekFirst()]+" right="+height[i]+" i="+i);
                                ans+=(Math.min(height[stack.peekFirst()],height[i])-bottom)*(i-stack.peekFirst()-1);
                                //System.out.println("ans="+ans);
                            }
                            if(stack.peekFirst()!=null&&height[i]>height[stack.peekFirst()]){;
                                continue;
                            }else{
                                break;
                            }
                        }else{
                            break;
                        }
                    }
                    stack.addFirst(i);
                }
            }
        }
        return ans;
    }
}


class Solution {
    public int trap(int[] height) {
        if(height.length<=2)
            return 0;
        
        Deque<Integer>stack=new ArrayDeque<>();
        stack.addFirst(-1);
        int ans=0;

        for(int i=0;i<height.length;i++){
            while(stack.peekFirst()!=-1&&height[i]>height[stack.peekFirst()]){
                int curBottom=height[stack.peekFirst()];
                while(stack.peekFirst()!=-1&&height[stack.peekFirst()]==curBottom){
                    stack.pop();
                }
                if(stack.peekFirst()==-1){
                    break;
                }else{
                    ans+=(Math.min(height[i],height[stack.peekFirst()])-curBottom)*(i-stack.peekFirst()-1);
                }
            }
            stack.addFirst(i);
        }
        return ans;
    }
}