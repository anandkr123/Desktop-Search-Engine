import java.io.*;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.nio.file.Files;
import java.nio.file.Paths;

public class XMLRead 
{
 public static void main(String argv[])throws IOException
{
Scanner sc=new Scanner(System.in);
try 
{
  System.out.println("\n\n\t1 : search for all information of semi-structured data ?\n \t2 : Search for specific information ? \n\t3 : Search for content retrieval of readable file\n\n\t\t ------------- choice-----------");
  int choice=sc.nextInt();
  if(choice==1)
  {
System.out.println("\n\tEnter the path of file");
String ss=sc.nextLine();
	 ss=sc.nextLine();
       String tag;
  File file = new File(ss);
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  DocumentBuilder db = dbf.newDocumentBuilder();
  Document doc = db.parse(file);
  doc.getDocumentElement().normalize();
  System.out.println("Enter the tag name");
  tag=sc.nextLine();
  //tag=sc.nextLine();
  NodeList nodeLst = doc.getElementsByTagName(tag);
  System.out.println("Information of all ");

  for (int s = 0; s < nodeLst.getLength(); s++) {

    Node fstNode = nodeLst.item(s);
    NodeList childLst = fstNode.getChildNodes();
    for(int q=0;q<childLst.getLength();q++)
    {
     Node fNode = childLst.item(q);
     String t = fNode.getNodeName();
     if(t.equals("#text"))
       continue;
    
    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
  
           Element fstElmnt = (Element) fstNode;
      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(fNode.getNodeName());
      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
      NodeList fstNm = fstNmElmnt.getChildNodes();
      System.out.println(fNode.getNodeName()+" : "  + ((Node) fstNm.item(0)).getNodeValue());

   }
    }
  }
  }
  else if(choice == 2)
   {
System.out.println("\n\tEnter the path of file");
String ss=sc.nextLine();
	ss=sc.nextLine();
       String tag;
  File file = new File(ss);
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  DocumentBuilder db = dbf.newDocumentBuilder();
  Document doc = db.parse(file);
  doc.getDocumentElement().normalize();
     System.out.println("Enter the tag name");
   tag=sc.nextLine();
  NodeList nodeLst = doc.getElementsByTagName(tag);
   System.out.println("Enter the field tags");
  int pos[]=new int[100];
  int j=1,i=0,k=0;
  String tags=sc.nextLine();
  String s1=tags;
  char c[]=tags.toCharArray();
  pos[0]=0;
  for( i=0;i<s1.length();i++)
  {
	if(c[i] == ' ')
	{
	pos[j]=i;
	j++;
	}
  }
  pos[j]=s1.length();
  String s2[]=new String[j];
  for(int p=0;p<=j;p++) 
  for( k=0;k<j;k++)
  {
	if(k==0)
	s2[k]=s1.substring(pos[k],pos[k+1]);
	else
	s2[k]=s1.substring(pos[k]+1,pos[k+1]);
	s2[k].trim();
  }
  System.out.println("Information of all ");  
  System.out.println("Information of subtags");

  for (int s = 0; s < nodeLst.getLength(); s++) {

    Node fstNode = nodeLst.item(s);
    for(int p=0;p<k;p++){
    
    if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
  
           Element fstElmnt = (Element) fstNode;
      NodeList fstNmElmntLst = fstElmnt.getElementsByTagName(s2[p]);
      Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
      NodeList fstNm = fstNmElmnt.getChildNodes();
      System.out.println(s2[p] +" : "  + ((Node) fstNm.item(0)).getNodeValue());
    }
   }
  }
}
else if (choice == 3)
{
System.out.print("\n\n \t Enter the path of file:- ");
String path=sc.nextLine();
path=sc.nextLine();
String c = new String(Files.readAllBytes(Paths.get(path)));
System.out.println("\nThe Contents of File are \n");
System.out.println("\n"+c);
}
}
 catch (Exception e) {
    e.printStackTrace();

  }
}
}