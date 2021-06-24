import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Point{
    int x;
    int y;
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}

public class problem19_2 {
    
    public static void main(String[]args){
        StringBuffer ans=new StringBuffer();
        Scanner scan=new Scanner(System.in);
        /*
        Scanner scan=null;
        try {
            scan = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        */
        int n=scan.nextInt();
        int m=scan.nextInt();
        scan.nextLine();

        //System.out.println("n="+n+" m="+m);

        ArrayList<Point> aSet=new ArrayList<>();
        ArrayList<Point> bSet=new ArrayList<>();

        for(int i=0;i<n;i++){
            int x=scan.nextInt();
            int y=scan.nextInt();
            String id=scan.nextLine().trim();
            if(id.equals("A")){
                aSet.add(new Point(x, y));
                //System.out.println("A:"+x+","+y);
            }else{
                bSet.add(new Point(x, y));
                //System.out.println("B:"+x+","+y);
            }
        }


        for(int i=0;i<m;i++){
            int C=scan.nextInt();
            int A=scan.nextInt();
            int B=scan.nextInt();
            if(scan.hasNextLine())
                scan.nextLine();
            //System.out.println("A="+A+" B="+B+" C="+C);
            Point tmpA=aSet.get(0);
            Point tmpB=bSet.get(0);
            boolean aSetCondition;
            boolean bSetCondition;

            if(A*tmpA.x+B*tmpA.y+C>0){
                aSetCondition=true;
                if(A*tmpB.x+B*tmpB.y+C<0){
                    bSetCondition=false;
                }else{
                    ans.append("No\n");
                    continue;
                }
            }else{
                aSetCondition=false;
                if(A*tmpB.x+B*tmpB.y+C>0){
                    bSetCondition=true;
                }else{
                    ans.append("No\n");
                    continue;
                }
            }

            boolean finish=false;

            for(int j=1;j<aSet.size();j++){
                tmpA=aSet.get(j);
                if(A*tmpA.x+B*tmpA.y+C>0){
                    if(!aSetCondition){
                        finish=true;
                        ans.append("No\n");
                        break;
                    }
                }else{
                    if(aSetCondition){
                        finish=true;
                        ans.append("No\n");
                        break;
                    }
                }

            }
            if(!finish){
                for(int j=1;j<bSet.size();j++){
                    tmpB=bSet.get(j);
                    if(A*tmpB.x+B*tmpB.y+C>0){
                        if(!bSetCondition){
                            finish=true;
                            ans.append("No\n");
                            break;
                        }
                    }else{
                        if(bSetCondition){
                            finish=true;
                            ans.append("No\n");
                            break;
                        }
                    }
                }    
            }
            if(!finish){
                ans.append("Yes\n");
            }
        }
        scan.close();
        System.out.print(ans.toString());

    }
}
