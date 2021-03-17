import java.util.Scanner;

public class problem2019_1 {
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        //System.out.println(n);
        scan.nextLine();
        int []res={0,0,0,0};
        int count=0;
        int curPeople=0;
        int curNum=1;
        while(count<n){
            if(curNum%7==0||isHaveSeven(curNum)){
                res[curPeople]++;
                //System.out.println(curPeople+","+curNum);
                curPeople=(curPeople+1)%4;
                curNum++;
            }else{
                curNum++;
                curPeople=(curPeople+1)%4;
                count++;
            }
        }
        for(int i=0;i<4;i++){
            System.out.println(res[i]);
        }
    }
    public static boolean isHaveSeven(int num){
        while(num>0){
            int cur=num%10;
            if(cur==7)
                return true;
            num=num/10;
        }
        return false;
    }
}
