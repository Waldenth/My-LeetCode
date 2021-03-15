import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class problem5{
    static class momentumDevice{
        public int x,y,z;
        public momentumDevice(){
            this.x=0;
            this.y=0;
            this.z=0;
        }

    }
    public static void main(String[]args){
        Scanner scan=null;
        try {
            scan = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int m=scan.nextInt();
        int n=scan.nextInt();
        scan.nextLine();
        //System.out.println("m= "+m+" n= "+n);
        momentumDevice momentumDevices[]=new momentumDevice[n+1];
        for(int i=0;i<=n;i++){
            momentumDevices[i]=new momentumDevice();
        }
        for(int i=0;i<m;i++){
            String []operationsStr=scan.nextLine().split("\\s+");
            //for(int j=0;j<operationsStr.length;j++){
            //    System.out.println(operationsStr[j]);
            //}
            int [] operationsNum=new int[operationsStr.length];
            for(int j=0;j<operationsStr.length;j++){
                operationsNum[j]=Integer.parseInt(operationsStr[j]);
            }
            int operationKind=operationsNum[0];
            int L=operationsNum[1];
            int R=operationsNum[2];
            //System.out.println("L= "+L+" R= "+R);
            switch (operationKind) {
                case 1:
                    for(int k=L;k<=R;k++){
                        momentumDevices[k].x+=operationsNum[3];
                        momentumDevices[k].y+=operationsNum[4];
                        momentumDevices[k].z+=operationsNum[5];
                    }
                    break;
                case 2:
                    for(int k=L;k<=R;k++){
                        momentumDevices[k].x=momentumDevices[k].x*operationsNum[3];
                        momentumDevices[k].y=momentumDevices[k].y*operationsNum[3];
                        momentumDevices[k].z=momentumDevices[k].z*operationsNum[3];
                    }     
                    break;
                case 3:
                    for(int k=L;k<R;k++){
                        int tmpX=momentumDevices[k].x;
                        int tmpY=momentumDevices[k].y;
                        int tmpZ=momentumDevices[k].z;
                        momentumDevices[k].x=tmpY;
                        momentumDevices[k].y=tmpZ;
                        momentumDevices[k].z=tmpX;
                    }
                    break;
                case 4:
                    int curX=0;
                    int curY=0;
                    int curZ=0; 
                    //System.out.println("查询 L="+L+" R="+R);   
                    for(int k=L;k<=R;k++){
                        curX+=momentumDevices[k].x;
                        curY+=momentumDevices[k].y;
                        curZ+=momentumDevices[k].z;        
                    
                        //System.out.println(momentumDevices[k].x+" "+momentumDevices[k].y+" "
                        //    +momentumDevices[k].z);
                    }
                    System.out.println((curX*curX+curY*curY+curZ*curZ));
                    break;
                default:
                    break;
            }
        }
        return;
    }
}