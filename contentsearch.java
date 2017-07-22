import java.util.Scanner;
import java.io.*;
class contentsearch
{
public static void main(String ...aer)throws IOException
{
int cnt=0;
Scanner sc=new Scanner(System.in);
System.out.println("Enter the path of folder");
String ss=sc.nextLine();
File f1=new File(ss);
File f2[]=f1.listFiles();
System.out.println("\n\tEnter the First(<=30) bytes of file\n\t \n\t Valid only for Readable files\n");
String s2=sc.nextLine();
for(File f5:f2)    
{
  FileInputStream fis = null;
      
    byte[] bs = new byte[30];

int i = 0;  
             // create new file input stream
String s5=ss+"/"+f5.getName();  
       fis = new FileInputStream(s5);

         // read bytes to the buffer
        
i=fis.read(bs,0,s2.length()); 

String s1=new String(bs);
String s3=s1.substring(0,s2.length());
if(s3.equals(s2))
{
cnt++;
System.out.println("\n\t\t Name of File is "+f5.getName());
break;
}
}
if(cnt == 0)
System.out.println("OOPs  ! File not found ");
}
}