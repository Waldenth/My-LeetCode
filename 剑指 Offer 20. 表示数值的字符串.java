import java.util.regex.*;
 
class Solution {
    enum State{
        STATE_START,
        STATE_SIGNED,
        STATE_IS_NUMBER,
        STATE_MAYBE_SNNUMBER,
        STATE_IS_SNNUMBER,
        STATE_MAYBE_FLOATNUMBER,
        STATE_IS_FLOATNUMBER,
        STATE_NONUMBER,
    };

    enum CharType{
        CHAR_SIGN,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_NUMBER,
        CHAR_OTHER,
    }

    public boolean isNumber(String s) {
        s=s.trim();
        if(s.equals(".")||s.equals("+.")||s.equals("-."))
            return false;
        if(Pattern.matches("\\.[e|E][0-9]*", s))
            return false;
        Map<State,Map<CharType,State>>Automaton=new HashMap<>();
        Map<CharType,State>start=new HashMap<>(){{
            put(CharType.CHAR_POINT,State.STATE_MAYBE_FLOATNUMBER);
            put(CharType.CHAR_SIGN,State.STATE_SIGNED);
            put(CharType.CHAR_NUMBER,State.STATE_IS_NUMBER);
            put(CharType.CHAR_OTHER,State.STATE_NONUMBER);
        }};

        Map<CharType,State>signed=new HashMap<>(){{
            put(CharType.CHAR_NUMBER,State.STATE_IS_NUMBER);
            put(CharType.CHAR_OTHER,State.STATE_NONUMBER);
            put(CharType.CHAR_POINT,State.STATE_MAYBE_FLOATNUMBER);
        }};

        Map<CharType,State>is_number=new HashMap<>(){{
            put(CharType.CHAR_EXP,State.STATE_MAYBE_SNNUMBER);
            put(CharType.CHAR_POINT,State.STATE_MAYBE_FLOATNUMBER);
            put(CharType.CHAR_NUMBER,State.STATE_IS_NUMBER);
            put(CharType.CHAR_OTHER,State.STATE_NONUMBER);
        }};

        Map<CharType,State>maybe_SNnumber=new HashMap<>(){{
            put(CharType.CHAR_NUMBER,State.STATE_IS_SNNUMBER);
            put(CharType.CHAR_SIGN,State.STATE_MAYBE_SNNUMBER); 
            put(CharType.CHAR_OTHER,State.STATE_NONUMBER);
        }};

        Map<CharType,State>is_SNnumber=new HashMap<>(){{
            put(CharType.CHAR_NUMBER,State.STATE_IS_SNNUMBER);
            put(CharType.CHAR_OTHER,State.STATE_NONUMBER);
        }};

        Map<CharType,State>maybe_FloatNumber=new HashMap<>(){{
            put(CharType.CHAR_NUMBER,State.STATE_IS_FLOATNUMBER);
            put(CharType.CHAR_OTHER,State.STATE_NONUMBER);
            put(CharType.CHAR_EXP,State.STATE_MAYBE_SNNUMBER);
        }};

        Map<CharType,State>is_FloatNumber=new HashMap<>(){{
            put(CharType.CHAR_EXP,State.STATE_MAYBE_SNNUMBER);
            put(CharType.CHAR_NUMBER,State.STATE_IS_FLOATNUMBER);
            put(CharType.CHAR_OTHER,State.STATE_NONUMBER);
        }};

        Automaton.put(State.STATE_START,start);
        Automaton.put(State.STATE_SIGNED,signed);
        Automaton.put(State.STATE_IS_NUMBER,is_number);
        Automaton.put(State.STATE_MAYBE_SNNUMBER,maybe_SNnumber);
        Automaton.put(State.STATE_MAYBE_FLOATNUMBER,maybe_FloatNumber);
        Automaton.put(State.STATE_IS_SNNUMBER,is_SNnumber);
        Automaton.put(State.STATE_IS_FLOATNUMBER,is_FloatNumber);

        State curState=State.STATE_START;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            CharType type=toCharType(ch);
            if(Automaton.get(curState).containsKey(type)){
                curState=Automaton.get(curState).get(type);
            }else{
                return false;
            }
            if(curState==State.STATE_NONUMBER)
                return false;
        }
        if(curState==State.STATE_IS_FLOATNUMBER||curState==State.STATE_IS_NUMBER||curState==State.STATE_IS_SNNUMBER||curState==State.STATE_MAYBE_FLOATNUMBER)
            return true;
        return false;
    }

    public CharType toCharType(char ch){
        if(ch<='9'&&ch>='0')
            return CharType.CHAR_NUMBER;
        if(ch=='E'||ch=='e')
            return CharType.CHAR_EXP;
        if(ch=='.')
            return CharType.CHAR_POINT;
        if(ch=='+'||ch=='-')
            return CharType.CHAR_SIGN;
        return CharType.CHAR_OTHER;
    }
}