import java.util.*;
import java.io.*;
public class Admin
{
    public static void mMenu()
    {
        int ch=0; 
        Scanner sc=new Scanner(System.in);
      abc:
      while(ch!=5)
       {
         System.out.println(" --------------------------------------------------------------------");
         System.out.println("|                                                                    |");
         System.out.println("|                          WELCOME  ADMIN                            |");
         System.out.println("|                                                                    |");
         System.out.println("|--------------------------------------------------------------------|");
         System.out.println("|                                                                    |");
         System.out.println("|                                                                    |");
         System.out.println("| PLEASE ENTER YOUR CHOICE:                                          |");
         System.out.println("|                                                                    |");
         System.out.println("| 1. CREATE A NEW ACCOUNT                                            |");
         System.out.println("| 2. DELETE AN ACCOUNT                                               |");
         System.out.println("| 3. DISPLAY ALL ACCOUNTS                                            |");
         System.out.println("| 4. MANAGE DATABASE                                                 |");
         System.out.println("| 5. LOG OFF                                                         |");
         System.out.println("|                                                                    |");
         System.out.println("|                                                                    |");
         System.out.println(" --------------------------------------------------------------------");
         String d=sc.nextLine();
        if(!(d.length()==1&&Character.isDigit(d.charAt(0))))
        {
               System.out.println(" NO SUCH OPTION EXISTS");
               try
                {
                 Thread.sleep(1000);
                }
                catch(InterruptedException e){}
               System.out.println('\u000C');
        }
       
        else
        abcd:
        {
            ch=Integer.parseInt(d);
           
            System.out.println('\u000C');
         
            switch(ch)
            {
                case 1:
                
                String un=UUID.randomUUID().toString().replaceAll("-","");
                String ps=UUID.randomUUID().toString().replaceAll("-","");
                un=un.substring(0,8);
                ps=ps.substring(0,8);
                System.out.println("NEW ACCOUNT GENERATED :\r");
                System.out.println("USERNAME : "+un);
                System.out.println("PASSWORD : "+ps);
                try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("AccountDetails.txt", true)))) 
                {
                    out.print(un);
                    out.println(" "+ps);
                }catch (IOException e) {}
                break;
            

                case 2:
                
                try
                {
                File inputFile = new File("AccountDetails.txt");
                File tempFile = new File("myTempFile.txt");

                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
                System.out.println("ENTER THE USERNAME TO BE DELETED");
                String le =sc.nextLine().toLowerCase() ;
                String ce;
                boolean flag=false;
                while((ce = reader.readLine()) != null) 
                {
                    String trimmedLine = ce.trim().toLowerCase();
                    if(trimmedLine.startsWith(le)) 
                    {
                        flag=true;
                    }
                    else
                    writer.write(ce + System.getProperty("line.separator"));
                }
                writer.close(); 
                reader.close(); 
                if(flag)
                {
                    try{
                    FileWriter fw=new FileWriter("AccountDetails.txt");  
                        fw.write("");  
                        fw.close();
                        }
                        catch(Exception e){}
                    try(PrintWriter ot = new PrintWriter(new BufferedWriter(new FileWriter("AccountDetails.txt",true)))){  
                        FileInputStream fin=new FileInputStream("myTempFile.txt");  
                        Scanner sc3=new Scanner(fin); 
                        while(sc3.hasNextLine())
                        {  
                            ot.println(sc3.nextLine());                               
                        }  
                        fin.close(); 
                        }catch(Exception e){}
                    System.out.println("Deletion Successful");
                }
                else
                System.out.println("NO USERNAME OF SUCH NAME EXISTS");
                }
                catch(Exception e){}
                break;
                
                case 3:
                System.out.println(" USERNAME        PASSWORD");
                try{  
                FileInputStream fin=new FileInputStream("AccountDetails.txt");  
                Scanner sc2=new Scanner(fin); 
                while(sc2.hasNextLine())
                {  
                      String s=sc2.next();
                      String s2=sc2.next();
                      System.out.println(" "+s+"        "+s2);
                }  
                fin.close();  
                }catch(Exception e){}
                break;
             
                case 4:
                DMS.dMenu(true);
                break;
                
                case 5:
                System.out.println(" LOGGING OFF");
                try
                {
                Thread.sleep(2000);
                }
                catch(InterruptedException e){}
                break abc;
            
                default:
                System.out.println(" NO SUCH OPTION EXISTS");
                try
                {
                Thread.sleep(1000);
                }
                catch(InterruptedException e){}
                System.out.println('\u000C');
                break abcd;
            }
            System.out.println("\n\n\n\n\n\n\n\n\n\n\nPLEASE PRESS ENTER TO CONTINUE");
            d=sc.nextLine();
                System.out.println('\u000C');
        }
            
       }
    }
   
}
