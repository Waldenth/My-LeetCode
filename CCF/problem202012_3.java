import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class MyDirectory{
    MyDirectory parentDirectory;
    String name;
    Map<String,MyDirectory> sonDirectories=new HashMap<>();

    int LD;
    int LR;

    MyDirectory(MyDirectory parentDirectory,String name){
        this.parentDirectory=parentDirectory;
        this.name=name;
    }
    MyDirectory(String name){
        this.name=name;
    }
    MyDirectory(){

    }

}

class MyFile{
    int size;
    MyDirectory parentDirectory;
    String name;
}


public class problem202012_3{

    static MyDirectory root=new MyDirectory(null,"rootDirectory");

    public static void main(String[]args){
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        scan.nextLine();
        for(int i=0;i<n;i++){
            String[] operations=scan.nextLine().split("\\s+");
            switch(operations[0]){
                case "C":
                    String path=operations[1];
                    int size=Integer.parseInt(operations[2]);


                    break;
                case "R":

                    break;
                
            }

        }

    }

    public static String findPath(String path){
        if(path.charAt(0)!='/'){
            return null;
        }
        for(int i=1;i<path.length();i++){
            
        }


        return path.substring(path.lastIndexOf("/"));
    }

}