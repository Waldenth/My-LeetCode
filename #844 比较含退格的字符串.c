char* GetStr(char*str){
    int length=strlen(str);
    char *res=(char*)malloc(sizeof(char)*(length+1));
    int resLength=0;
    for(int i=0;i<length;i++){
        if(str[i]!='#'){
            res[resLength]=str[i];
            resLength++;
        }else if(resLength>0){
            resLength--;
        }   
    }
    res[resLength]='\0';
    return res;
}
bool backspaceCompare(char* S, char* T){
    return strcmp(GetStr(S),GetStr(T))==0;
}