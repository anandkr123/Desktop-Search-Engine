import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
class model
{
public static void main(String ...q)
{
int d,a,count=0,k=1,t=1;
 int e,x=0,g=0,f=0;
char ch1[]=new char[30];
char ch2[]=new char[20];
char ch;
String s,sm1;
 Scanner sc=new Scanner(System.in);
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
long n,lm;
 String s1,s2,s3,s4,s5;
File f1,f3,f4;
f1=null;
System.out.println("\n\t  Enter the Drive , Folder , Relationship you want To Query");
System.out.println("\n");
String s7=sc.nextLine();
e=s7.indexOf("has");
String s6=s7.substring(0,e);
String s8=s7.substring(e);
ch=s6.charAt(0);
s=ch+":";
s6=s6.substring(2);
s6=s6.replace('"','/');
ch1=s6.toCharArray();
for(int r=0;r<ch1.length;r++)
{
if( (ch1[r] == '/' && ch1[r+1] == ' ') || ( ch1[r] == '/' && ch1[r+1] == '\0') )
{
r++;
continue;
}
else
{
ch2[g]=ch1[r];
g++;
}
}
ch2[g]='\0';
for(char c:ch2)
{
String temp=""+c;
s=s+temp;
}
s=s.trim();
f1=new File(s);
File f2[]=f1.listFiles();
SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
HashMap < Integer, String > filename = new HashMap<Integer, String>();
HashMap < Integer , String > fileext = new HashMap<Integer ,String>();
HashMap < Integer , Long> filesize = new HashMap<Integer,Long>();
HashMap < Integer , String>foldname = new HashMap<Integer , String>();
HashMap < Integer , Long>foldsize = new HashMap<Integer , Long>();
HashMap < Integer , String>filename1 = new HashMap<Integer , String>();
HashMap < Integer , Long> filesize1 = new HashMap<Integer,Long>();
HashMap < Integer , String> filelastmodi = new HashMap<Integer,String>();
HashMap < Integer , String> foldlastmodi = new HashMap<Integer,String>();
HashMap < Integer , String> filelastmodi1 = new HashMap<Integer,String>();
//HashMap <Integer ,  String>  contentfile=new contentfile<Integer,String>();
int i=1,j=1;
for(File f5:f2)                                                                            
{
Date dt=new Date(f5.lastModified());
String ef=sdf.format(dt);
s1=f5.getName();
n=f5.length();
if(s1 != null)
{
filename.put(i,s1);
filesize.put(i,n);
filelastmodi.put(i,ef);
i++;
}
else 
break;
if(f5.isFile())
{
filename1.put(k,s1);
filesize1.put(k,n);
filelastmodi1.put(k,ef);
k++;
}
else if(f5.isDirectory())
{
foldname.put(t,s1);
foldsize.put(t,n);
foldlastmodi.put(t,ef);
t++;
}
s1="";
}
for(File fe:f2)
{
s2=fe.getName();
if(fe != null)
{
d=s2.lastIndexOf('.');
s3=s2.substring(d+1);
fileext.put(j,s3);
j++;
}
else 
break;
s2=s3=null;
}
if(s8.equalsIgnoreCase("hasfile"))
{
System.out.println("Name Of File\tSize\tDate Modified");
int y=1;
String var=filename1.get(y);
while(var != null)
{
System.out.println(filename1.get(y)+"\t"+filesize1.get(y)+"\t"+filelastmodi1.get(y) +"\n");
y++;
//var=null;
var=filename1.get(y);
}
}
else if(s8.equalsIgnoreCase("hasfolder"))
{
int z=1;
String var1=filename1.get(z);
while(var1!= null)
{
System.out.println("Name Of File\tSize\tDate Modified");
System.out.println(foldname.get(z)+"\t"+foldsize.get(z)+"\t"+foldlastmodi.get(z) + "\n");
z++;
//var1=null;
var1=foldname.get(z);
}
}
System.out.println("\n\t       By which Property you want to search\n");
System.out.println(" \t\t1-> Name \n\n\t\t2-> hasSize \n\n\t\t3-> hasExtension\n\n\t\t4-> lastModified\n" );
System.out.println("\t\t ?????????? Choice ??????????\n \n\t");
int choice=sc.nextInt();
switch(choice)
{
case 1:
System.out.println("Enter the name of file");
String sm=sc.nextLine();
s4=sc.nextLine();
Set set = filename.entrySet();
      Iterator iterator = set.iterator();
      while(iterator.hasNext()) {
         Map.Entry mentry = (Map.Entry)iterator.next();
         if(s4.equals(mentry.getValue()))
	{
count++;
         a=(int)mentry.getKey();
	System.out.println("Name\tType\tValue\tSize\tExtension\tLastModified");
System.out.println("hasFile\tString\t"+filename.get(a)+"\t"+filesize.get(a)+"\t"+fileext.get(a)+"\t"+filelastmodi.get(a));

	  break;
         }
	}
if(count == 0)
System.out.println("No such file of given extension exist");
count=0;
break;
case 2:
System.out.println("Enter the size of the file");
long a1=sc.nextInt();
Set set1 = filesize.entrySet();
      Iterator iterator1 = set1.iterator();
      while(iterator1.hasNext()) {
         Map.Entry mentry1 = (Map.Entry)iterator1.next();
         if(a1==(long)mentry1.getValue())
	{
count++;
          a=(int)mentry1.getKey();
	System.out.println("Name\tType\tValue\tName of file\tExtension\tLastModified");
        System.out.println("hasSize\tInteger\t"+filesize.get(a)+"\t"+filename.get(a)+"\t"+fileext.get(a)+"\t"+filelastmodi.get(a));

	  break;
         }
	}
if(count == 0)
System.out.println("No Such file of given size exist");
count=0;
break;
case 3:
System.out.println("Enter the extension of file");
 sm1=sc.nextLine();
s4=sc.nextLine();
Set set2 = fileext.entrySet();
      Iterator iterator2 = set2.iterator();

      while(iterator2.hasNext()) 
    {
        
         Map.Entry mentry2 = (Map.Entry)iterator2.next();
         if(s4.equals(mentry2.getValue()))
	{ 
          count++;
         a=(int)mentry2.getKey();
	  if(count == 1)
           System.out.println("Name\t\tType\tValue\tSize\tName of File");
         System.out.println("hasExtension\tString\t"+fileext.get(a)+"\t"+filesize.get(a)+"\t"+filename.get(a)+"\t"+filelastmodi.get(a));
         }
	}
if(count == 0)
System.out.println("No such file of given extension exist");
count=0;
break;
case 4:
System.out.print("\n\tEnter the modified time (dd-MM-yyyy) :- ");
sm1=sc.nextLine();
s4=sc.nextLine();
Set set3 = filelastmodi1.entrySet();
System.out.println("\nName\t type\tSize\tName of File\n");
      Iterator iterator3 = set3.iterator();

      while(iterator3.hasNext()) 
    {
        
         Map.Entry mentry2 = (Map.Entry)iterator3.next();
         if(s4.equals(mentry2.getValue()))
	{ 
          count++;
         a=(int)mentry2.getKey();
           
         System.out.println("lastModified\tString"+"\t"+filesize1.get(a)+"\t"+filename1.get(a));
         }
	}
if(count == 0)
System.out.println("No such file of given modified time exist");
count=0;
break;
}
}
}