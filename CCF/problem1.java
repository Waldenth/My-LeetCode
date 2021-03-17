import java.util.Scanner;

public class problem1{
    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        scan.nextLine();
        int []w=new int [n];
        int []score=new int [n];
        for(int i=0;i<n;i++){
            w[i]=scan.nextInt();
            score[i]=scan.nextInt();
            scan.nextLine();
        }
        int res=0;
        for(int i=0;i<n;i++){
            res+=w[i]*score[i];
        }
        if(res<0)
            res=0;
        System.out.println(res);
    }
}