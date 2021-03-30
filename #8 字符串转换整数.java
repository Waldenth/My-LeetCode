
class Solution {
    public int myAtoi(String s) {
        //s=s.trim();
        Automaton automaton=new Automaton();
        for(int i=0;i<s.length();i++){
            automaton.parser(s.charAt(i));
        }
        return (int)(automaton.sign*automaton.ans);
    }
}

class Automaton{
    public int sign = 1;
    public long ans = 0;
    private String state = "start";

    private Map<String,String[]>table=new HashMap<>(){{
        put("start",new String[]{"start","signed","in_number","end"}); // 空格 、 +/- 、 number 、 other
        put("signed",new String[]{"end","end","in_number","end"});
        put("in_number",new String[]{"end","end","in_number","end"});
        put("end",new String[]{"end","end","end","end"});
    }};

    public void parser(char c){
        state=table.get(state)[getNextState(c)];
        switch(state){
            case "start":
                break;
            case "end":
                break;
            case "in_number":
                ans=ans*10+c-'0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
                break;
            case "signed":
                sign = c=='+'?1:-1;
                break;
        }
    }

    private int getNextState(char c){
        if(c==' ')
            return 0;
        if(c=='+'||c=='-')
            return 1;
        if(Character.isDigit(c))
           return 2;
        return 3;
    }

}




